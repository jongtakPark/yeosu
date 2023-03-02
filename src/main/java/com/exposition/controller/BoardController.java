package com.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	//설문조사게시판
	@GetMapping(value="/survey")
	public String survey() {
		return "board/survey";
	}
	//국민아이디어
		@GetMapping(value="/idea")
		public String idea() {
			return "board/idea";
		}
	//국민아이디어
		@GetMapping(value="/volunteer")
		public String volunteer() {
			return "board/volunteer";	
			}	
    //관람후기
		@GetMapping(value="/reviewshow")	
		public String reviewshow() {
			return "board/reviewshow";
				}	
}
