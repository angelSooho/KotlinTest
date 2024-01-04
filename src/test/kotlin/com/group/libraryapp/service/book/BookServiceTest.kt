package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.Member
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @AfterEach
    fun tearDown() {
        bookRepository.deleteAll()
    }

    @DisplayName("책 등록이 정상 동작한다.")
    @Test
    fun savedBookTdst() {
        //given
        val request = BookRequest("title")

        //when
        bookService.saveBook(request)

        //then
        val book = bookRepository.findByName(request.name)
        assertThat(book.get().name).isEqualTo(request.name)
    }

    @DisplayName("책 대출이 정상 동작한다.")
    @Test
    fun loanBookTest() {
        //given
        bookRepository.save(Book("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(Member("이수호", 26))

        //when
        val bookLoanRequest = BookLoanRequest("이수호", "이상한 나라의 엘리스")
        bookService.loanBook(bookLoanRequest)

        //then
        val books = userLoanHistoryRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].bookName).isEqualTo(bookLoanRequest.bookName)
        assertThat(books[0].member.id).isEqualTo(savedUser.id)
        assertThat(books[0].isReturn).isFalse
    }

    @DisplayName("책이 진작 대출되어 있다면, 신규 대출이 실패한다.")
    @Test
    fun loanBookFailTest() {
        //given
        bookRepository.save(Book("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(Member("이수호", 26))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "이상한 나라의 엘리스", false))
        val request = BookLoanRequest("이수호", "이상한 나라의 엘리스")

        //when & then
        assertThatThrownBy { bookService.loanBook(request) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("진작 대출되어 있는 책입니다")
    }

    @DisplayName("책 반납이 정상 동작한다.")
    @Test
    fun returnBookTest() {
        //given
        bookRepository.save(Book("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(Member("이수호", 26))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "이상한 나라의 엘리스", false))
        val request = BookReturnRequest("이수호", "이상한 나라의 엘리스")

        //when
        bookService.returnBook(request)

        //then
        val books = userLoanHistoryRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].isReturn).isTrue()
    }
}