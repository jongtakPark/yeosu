package com.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/menu")
public class MenuContoller {
	//행사장 오시는길
	@GetMapping(value="/directions")
	public String direction() {
		return "introduction/directions";
	}
	//전시관소개
	@GetMapping(value="/exhibition")
	public String exhibition() {
		return "introduction/exhibition";
	}
}
