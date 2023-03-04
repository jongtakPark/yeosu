package com.exposition.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposition.service.MailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/mail")
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;
	
	//회원가입시 입력한 이메일로 인증번호 메일 발송
	@GetMapping(value="/sendmail")
	@ResponseBody
	public String mailAuth(String email) throws Exception {
	    String authKey = mailService.sendAuthMail(email); 
	    return authKey;
	}
}
