package com.exposition.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;

import com.exposition.dto.MemberFormDto;
import com.exposition.dto.FreeBoardDto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="freeBoard")
@RequiredArgsConstructor
public class FreeBoard extends BaseEntity{

	// 글번호
	@Id
	@Column(name="freeBoard_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// 제목
	@NotEmpty(message = "제목을 적어주세요.")
	private String title;

	// 내용
	@Column(length = 2000)
	private String content; 
	
	// 조회수
//	@ColumnDefault("0")
//	private int viewCnt;
	
	// 
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "member_id")
//	private Member member;

	
	public  static FreeBoard createfreeBoard(FreeBoardDto freeBoardDto) {
			FreeBoard freeBoard = new FreeBoard();

			freeBoard.setTitle(freeBoardDto.getTitle());
			freeBoard.setContent(freeBoardDto.getContent());

			return freeBoard;
	}
}
