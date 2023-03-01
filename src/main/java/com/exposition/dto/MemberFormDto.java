package com.exposition.dto;

import lombok.Data;
@Data
public class MemberFormDto {
	
//	@NotBlank(message = "아이디는 필수 입력 값입니다.")
//	@Length(max=8, message="아이디는 8자 이하로 입력해주세요.")
    private String mid;
	
//	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String name;
    
//	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
//	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String password;
    private String confirmPassword;
    
//    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
//    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;
    
    private String tel;
}
