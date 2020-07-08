package com.example.demo.service.Impl;

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
	public int passwdcheck(MemberVO member) {
		return memberDAO.passwdcheck(member);
	}
}
