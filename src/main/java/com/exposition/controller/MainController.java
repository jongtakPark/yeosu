package com.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposition.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller

public class MainController {
	
	//메인화면
	@RequestMapping(value="/")
	public String main() {
		return "main";
	}
}
