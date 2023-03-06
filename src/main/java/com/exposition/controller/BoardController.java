package com.exposition.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposition.dto.FreeBoardDto;
import com.exposition.entity.FreeBoard;
import com.exposition.entity.Member;
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
	
	//게시판 화면
	@GetMapping(value="/freeboard")
	public String freeBoard() {
		return "board/freeBoard";
	}
	
	//게시판 작성 화면
	@GetMapping(value="/write")
	public String write(Model model) {
		model.addAttribute("freeBoardDto",  new FreeBoardDto());
		return "board/write";
	}
	
	//게시글 작성
	@PostMapping(value="/new")
	public String newBoard(FreeBoardDto freeBoardDto, Model model, Member member) {
		FreeBoard freeBoard = FreeBoard.create(freeBoardDto, member);
		boardService.saveBoard(freeBoard);
		List<FreeBoard> list = boardService.boardList();
		model.addAttribute("list",list);
		return "board/freeBoard";
	}
}
