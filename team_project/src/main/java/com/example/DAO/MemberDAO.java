package com.example.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.MemberDTO;

@Mapper
public interface MemberDAO {
	public MemberDTO loginProc(MemberDTO mdto);

	public int updateLastLogin(MemberDTO mdto);

	public int emailChange(MemberDTO mdto);

	public int updateTel(String tel);

	public int updateTel(MemberDTO mdto);

	public void updatePw(MemberDTO mdto);

	public int updateAddress(MemberDTO sessionMdto);

	public MemberDTO id_check(MemberDTO mdto);

	public MemberDTO pwCheck(MemberDTO mdto);
}
