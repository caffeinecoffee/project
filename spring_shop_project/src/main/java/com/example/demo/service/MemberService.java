package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.MemberVO;

@Service
public interface MemberService {

	public int idcheck(String id);

	public int registerPro(MemberVO member);

	public MemberVO loginPro(MemberVO member);

	public MemberVO selectMember(String mem_id);

	public void memberUpdate(MemberVO member);

	public List<MemberVO> memberMgr();

	public int registerWithdrawal(String mem_id);
}
