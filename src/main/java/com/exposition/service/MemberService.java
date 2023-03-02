package com.exposition.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposition.entity.Member;
import com.exposition.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	//회원가입
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}
	//회원 중복검사
	private void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByMid(member.getMid());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다");
		}	
	}
	//중복검사
	public boolean checkMidDuplicate(String mid) {
		return memberRepository.existsByMid(mid);
	}
	//로그인
	@Override
	public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException{
		
		Member member = memberRepository.findByMid(mid);
		if(member==null) {
			throw new UsernameNotFoundException(mid);
		}
		
		return User.builder().username(member.getMid()).password(member.getPasswoad()).roles(member.getRole().toString()).build();
	}
}
