package com.exposition.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
	
	//메인화면
	@RequestMapping(value="/")
	public String main() {
		return "main";
	}
}
