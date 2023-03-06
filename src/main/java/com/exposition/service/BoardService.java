package com.exposition.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposition.entity.FreeBoard;
import com.exposition.entity.Member;
import com.exposition.repository.BoardRepository;
import com.exposition.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	
	//게시판 글 작성
	public FreeBoard saveBoard(FreeBoard freeBoard) {
		return boardRepository.save(freeBoard);
	}
	
	//게시판 리스트 출력
	public List<FreeBoard> boardList(){
		return boardRepository.findAll();
	}
	
	
}
