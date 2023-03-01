package com.exposition.dto;

import lombok.Data;

@Data
public class MemberFormDto {

    private String mid;
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
    private String tel;
}
