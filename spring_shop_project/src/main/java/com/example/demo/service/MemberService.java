package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.MemberVO;

@Service
public interface MemberService {

	public int idcheck(String id);

	public int registerPro(MemberVO member);

	public int passwdcheck(MemberVO member);

}
