package com.exposition.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposition.dto.FreeBoardDto;
import com.exposition.entity.FreeBoard;
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
		public String boardList(Model model, @PageableDefault(page=0, size=10, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		
	        Page<FreeBoard> list = boardService.boardList(pageable);

	        model.addAttribute("freeboard",boardService.boardList(pageable));

	        //페이징	        
	        int nowPage = list.getPageable().getPageNumber() + 1;	        
	        int startPage =  Math.max(nowPage - 4, 1);
	        int endPage = Math.min(nowPage+9, list.getTotalPages());

	        model.addAttribute("list", list);
	        model.addAttribute("nowPage",nowPage);
	        model.addAttribute("startPage", startPage);
	        model.addAttribute("endPage", endPage);



	        return "board/freeboard";
	    }
	
			
	// 글쓰기 페이지로 이동
	@GetMapping(value="/boardwrite")
	public String boardwrite(Model model) {
		model.addAttribute("freeBoardDto", new FreeBoardDto());
		return "board/boardwrite";
	}	
			
	// 글쓰기
	@PostMapping(value="/new")
	public String write(FreeBoardDto freeBoardDto, Model model) {
		FreeBoard freeBoard = FreeBoard.createfreeBoard(freeBoardDto);
		boardService.saveBoard(freeBoard);
		return "redirect:/board/freeboard";
		}	
	
	// 게시글 상세보기
	@GetMapping(value="/view")
	public String boardView(@RequestParam("list.id") Long id, Model model) {
		Optional<FreeBoard> view = boardService.findBoard(id);
		System.out.println(view);
		model.addAttribute("view", view);
		return "board/view";
	}
	
    
}
