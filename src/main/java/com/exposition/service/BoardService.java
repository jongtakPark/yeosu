package com.exposition.service;

import java.util.List;

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
	
	public List<FreeBoard> findList() {
		return boardRepository.findAll();
	}
	
	public FreeBoard saveBoard(FreeBoard freeBoard) {
		return boardRepository.save(freeBoard);
	}
	
}
