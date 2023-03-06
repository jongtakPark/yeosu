package com.exposition.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class FreeBoardDto {

	private Long id;
	@NotEmpty(message = "제목을 적어주세요.")
	private String title;
	private String content;
	
}
