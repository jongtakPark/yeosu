package com.exposition.entity;

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

import lombok.Data;

@Entity
@Data
@Table(name="freeBoard")
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
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "company_id")
	private Company company;


}
