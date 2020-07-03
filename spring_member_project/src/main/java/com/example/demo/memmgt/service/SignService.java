package com.example.demo.memmgt.service;

import java.util.List;

import com.example.demo.memmgt.dto.MemberVO;
import com.example.demo.memmgt.dto.PageVO;

public interface SignService {

	public int DataSave(MemberVO mvo);

	public List<MemberVO> getMembers(PageVO pvo);

	public MemberVO getMember(MemberVO mvo);

	public MemberVO modifyMember(MemberVO mvo);

	public void memberDelete(MemberVO mvo);

	public int idcheck(String id);
	
}
