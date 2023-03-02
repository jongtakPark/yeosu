package com.exposition.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposition.dto.MemberFormDto;
import com.exposition.entity.Member;
import com.exposition.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/signup")
@RequiredArgsConstructor
public class MemberController{
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	//로그인창으로 이동
	@GetMapping(value="/login")
	public String login() {
		return "member/loginForm";
	}
	//로그인 오류시
	@GetMapping(value="/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요.");
		return "member/loginForm";
	}
	//이용약관 동의창으로 이동
	@GetMapping(value="/agreement")
	public String agreement() {
		return "member/agreement";
	}
	//기업 회원가입창으로 이동
	@GetMapping(value="/company")
	public String companySignUp() {
		return "member/companySignUp";
	}
	//일반 회원가입창으로 이동
	@GetMapping(value="/personal")
	public String personalSignUp(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
		return "member/personalSignUp";
	}
	//일반회원가입
	@PostMapping(value="/new")
	@Validated
	public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "member/personalSignUp";
		}
		
		try {
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		} catch(IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/personalSignUp";
		}
		
		return "redirect:/";
	}
	//아이디 중복검사
	@GetMapping(value="/exists")
	public HashMap<String, Object> checkMidDuplicate(String mid){
		HashMap<String, Object> map = new HashMap<>();
		map.put("result", memberService.checkMidDuplicate(mid));
		return map;
	}

}
