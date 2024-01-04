package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.Member
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository,
) {

    @AfterEach
    fun tearDown() {
        userRepository.deleteAll()
    }

    @DisplayName("사용자 저장 테스트")
    @Test
    fun savedUserTest() {
        //given
        val request = UserCreateRequest("이수호", null)

        //when
        userService.saveUser(request)

        //then
        val users = userRepository.findAll()
        assertThat(users).hasSize(1)
        assertThat(users[0].name).isEqualTo("이수호")
        assertThat(users[0].age).isNull()
    }

    @DisplayName("사용자 조회 테스트")
    @Test
    fun getUsersTest() {
        //given
        userRepository.saveAll(listOf(
            Member("이수호1", 25),
            Member("이수호2", 26),
            Member("이수호3", 27),
            Member("이수호4", 28),
            Member("이수호5", 29),
        ))

        //when
        val users = userService.getUsers()

        //then
        assertThat(users).hasSize(5)
        assertThat(users).extracting("name", "age")
            .containsExactlyInAnyOrder(
                tuple("이수호1", 25),
                tuple("이수호2", 26),
                tuple("이수호3", 27),
                tuple("이수호4", 28),
                tuple("이수호5", 29),
            )
    }

    @DisplayName("사용자 수정 테스트")
    @Test
    fun updateUserNameTest() {
        //given
        val savedUser = userRepository.save(Member("이수호", 25))
        val request = UserUpdateRequest(savedUser.id, "B")

        //when
        userService.updateUserName(request)

        //then
        val user = userRepository.findById(savedUser.id).get()
        assertThat(user.name).isEqualTo("B")
        assertThat(user.age).isEqualTo(25);
    }

    @DisplayName("사용자 삭제 테스트")
    @Test
    fun deletedUserTest() {
        //given
        val savedUser = userRepository.save(Member("이수호", 25))

        //when
        userService.deleteUser("이수호")

        //then
        val users = userRepository.findAll();
        assertThat(users).hasSize(0)
    }
}