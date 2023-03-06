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

import com.exposition.dto.FreeBoardDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="freeBoard")
@RequiredArgsConstructor
public class FreeBoard extends BaseEntity{

	@Id
	@Column(name="freeBoard_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "제목을 적어주세요.")
	private String title;

	@Column(length = 2000)
	private String content; 
	
	@ColumnDefault("0")
	private int viewCnt;
	
	private String writer;
	
//	@ManyToOne(optional = false, cascade = CascadeType.ALL)
//	@JoinColumn(name = "member_id")
//	private Member member;

	public static FreeBoard create(FreeBoardDto freeBoardDto, Member member) {
		FreeBoard freeBoard = new FreeBoard();
		freeBoard.setTitle(freeBoardDto.getTitle());
		freeBoard.setContent(freeBoardDto.getContent());
		freeBoard.setWriter(member.getMid());
		freeBoard.setRegisterTime(LocalDateTime.now());
		return freeBoard;
	}
}
