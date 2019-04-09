package com.va.laundryjunction.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private int id;
  private String username;
  private String hashedPassword;
  private String salt;
  private String firstName;
  private String lastName;
}
