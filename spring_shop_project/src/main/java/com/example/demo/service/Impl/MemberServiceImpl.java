package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.MemberDAO;
import com.example.demo.DTO.MemberVO;
import com.example.demo.service.MemberService;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	MemberDAO memberDAO;

	@Override
	public int idcheck(String id) {
		return memberDAO.idcheck(id);
	}

	@Override
	public int registerPro(MemberVO member) {
		return memberDAO.registerPro(member);
	}

	@Override
	public MemberVO loginPro(MemberVO member) {
		return memberDAO.loginPro(member);
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		return memberDAO.selectMember(mem_id);
	}

	@Override
	public void memberUpdate(MemberVO member) {
		memberDAO.memberUpdate(member);
	}

	@Override
	public List<MemberVO> memberMgr() {
		return memberDAO.memberList();
	}

	@Override
	public int registerWithdrawal(String mem_id) {
		return memberDAO.registerWithdrawal(mem_id);
	}
}
