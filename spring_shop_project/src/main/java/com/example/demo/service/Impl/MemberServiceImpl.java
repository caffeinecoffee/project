package com.example.demo.service.Impl;

import com.example.demo.DAO.memberDAO;
import com.example.demo.service.MemberService;

public class MemberServiceImpl implements MemberService {

	@Override
	public int idcheck(String id) {
		return memberDAO.idcheck(id);
	}

}
