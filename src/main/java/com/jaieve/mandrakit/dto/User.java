package com.jaieve.mandrakit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String userName;
    private String password;
    private int age;
    private String job;
    private String region;
    private String goalKey;
}
