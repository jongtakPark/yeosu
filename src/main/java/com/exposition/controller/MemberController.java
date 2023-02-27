package com.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/signup")
public class MemberController {
	//로그인창
	@GetMapping(value="/login")
	public String login() {
		return "/member/loginForm";
	}
	//이용약관 동의
	@GetMapping(value="/agreement")
	public String agreement() {
		return "/member/agreement";
	}
	//기업 회원가입
	@GetMapping(value="/company")
	public String companySignUp() {
		return "member/companySignUp";
	}
	//일반 회원가입
	@GetMapping(value="/personal")
	public String personalSignUp() {
		return "member/personalSignUp";
	}
	
}
