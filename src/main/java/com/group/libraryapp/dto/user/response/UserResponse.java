package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.Member;

public class UserResponse {

  private final long id;
  private final String name;
  private final Integer age;

  public UserResponse(Member member) {
    this.id = member.getId();
    this.name = member.getName();
    this.age = member.getAge();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

}
