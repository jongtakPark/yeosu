package com.exposition.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposition.dto.FreeBoardDto;
import com.exposition.entity.FreeBoard;
import com.exposition.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	// 게시판 목록 출력
	public List<FreeBoard> findList() {
		return boardRepository.findAll();
	}
	
	// 게시판 저장
	public FreeBoard saveBoard(FreeBoard freeBoard) {
		return boardRepository.save(freeBoard);
	}

	// 게시판 글번호로 조회
	public FreeBoard findById(Long id) {
		return boardRepository.findById(id).get();
	}

	// 게시판 수정
	public FreeBoard updateboard(Long id) {
		return boardRepository.findById(id).get();
	}

	// 게시판 삭제
	public void delete(Long id) {
		boardRepository.deleteById(id);
	}
	
}
