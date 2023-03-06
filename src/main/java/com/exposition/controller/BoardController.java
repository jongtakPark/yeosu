package com.exposition.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposition.dto.FreeBoardDto;
import com.exposition.entity.FreeBoard;
import com.exposition.repository.BoardRepository;
import com.exposition.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	//설문조사게시판
	@GetMapping(value="/survey")
	public String survey() {
		return "board/survey";
	}
	
	//자유게시판
			@GetMapping(value="/freeboard")
			public String freeboard(Model model) {
				model.addAttribute("freeboard",boardService.findList());
				System.out.println(model);
				return "board/freeboard";
			}
			
	// 글쓰기 페이지로 이동
			@GetMapping(value="/boardwrite")
			public String boardwrite(Model model) {
				model.addAttribute("freeBoardDto", new FreeBoardDto());
				return "board/boardwrite";
			}	
			
			// 글쓰기
			@PostMapping(value="/write")
			public String write(FreeBoardDto freeBoardDto, Model model) {
				FreeBoard freeBoard = FreeBoard.createfreeBoard(freeBoardDto);
				boardService.saveBoard(freeBoard);
				return "redirect:/board/freeboard";
			}	
			
			// 
}
