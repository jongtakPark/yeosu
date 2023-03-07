package com.exposition.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//자유게시판
			@GetMapping(value="/freeboard")
			public String freeboard(Model model) {
				model.addAttribute("freeboard",boardService.findList());
				return "board/freeboard";
			}
			
			// 글쓰기 페이지로 이동
			@GetMapping(value="/boardwrite")
			public String boardwrite(Model model){				
				model.addAttribute("freeBoardDto", new FreeBoardDto());
				return "board/boardwrite";
			}	
			
			// 글쓰기
			@PostMapping(value="/write")
			public String write(FreeBoardDto freeBoardDto) {
				FreeBoard freeBoard = FreeBoard.createfreeBoard(freeBoardDto);
				boardService.saveBoard(freeBoard);
				return "redirect:/board/freeboard";
			}	
			
			// 게시판 글 상세보기
			@GetMapping(value="/detail/{id}")
			public String detail(@PathVariable("id")  Long id,Model model) {
				FreeBoard freeBoard = boardService.findById(id);
				model.addAttribute("freeboard", freeBoard);
				return "board/boarddetail";
			}
				
			
			// 게시판 글 수정페이지 이동
			@GetMapping(value="/modify/{id}")
			public String modify(@PathVariable("id")  Long id,Model model) {
				FreeBoard freeBoard = boardService.findById(id);
				model.addAttribute("freeboard", freeBoard);
				return "board/boardmodify";
			}			
			
			
			// 게시판 글 수정완료 후 게시판 리스트로 이동
			@PutMapping(value="/modify/action/{id}")
			public String modifyaction(@PathVariable("id")  Long id,HttpServletRequest request,Model model,
					@RequestParam("title") String title, @RequestParam("content") String content,FreeBoardDto freeBoardDto) {
				FreeBoard freeboard = boardService.updateboard(id);
				freeBoardDto.setContent(content);
				freeBoardDto.setTitle(title);
				freeBoardDto.setId(id);
				freeboard = freeboard.createfreeBoard(freeBoardDto);
				boardService.saveBoard(freeboard);
				model.addAttribute("freeboard", boardService.findList());
				return "redirect:/board/freeboard";
			}	
			
			// 게시판 삭제
			@GetMapping(value="/delete/{id}")
			public String delete(@PathVariable("id")  Long id,HttpServletRequest request,Model model,FreeBoardDto freeBoardDto) {
				boardService.delete(id);
				return "redirect:/board/freeboard";
			}	
			
}
