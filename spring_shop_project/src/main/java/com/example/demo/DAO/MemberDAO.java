package com.example.demo.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.MemberVO;

@Mapper
public interface MemberDAO {

	public int idcheck(String id);
	public int registerPro(MemberVO member);
	public int passwdcheck(MemberVO member);
	public MemberVO selectMember(String mem_id);
	public void memberUpdate(MemberVO member);
}
