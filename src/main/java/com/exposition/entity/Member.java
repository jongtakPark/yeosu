package com.exposition.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.exposition.constant.Role;
import com.exposition.dto.MemberFormDto;

import lombok.Data;

@Entity
@Table(name="member")
@Data

public class Member {
	
	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String mid;
	private String passwoad;
	private String name;
	@Column(unique=true)
	private String email;	
	private String address;
	private String tel;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	//스프링시큐리티 설정 클래스에(SecurityConfig.java) 등록한 BCryptPasswordEncoder Bean을 파라미터로 넘겨서 비밀번호를 암호화
//	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
//		Member member = new Member();
//		member.setMid(memberFormDto.getMid());
//		member.setName(memberFormDto.getName());
//		String password = passwordEncoder.encode(memberFormDto.getPassword());
//		member.setPasswoad(password);
//		member.setEmail(memberFormDto.getEmail());
//		member.setAddress(memberFormDto.getAddress());
//		member.setTel(memberFormDto.getTel());
//		member.setRole(Role.USER);
//		return member;
//	}
}
