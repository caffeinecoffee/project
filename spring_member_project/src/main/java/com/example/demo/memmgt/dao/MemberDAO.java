package com.example.demo.memmgt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.memmgt.dto.MemberVO;

@Mapper
public interface MemberDAO {
	public int SaveData(MemberVO mvo);
	public List<MemberVO> getMembers(Map<String, Integer> hmap);
	public MemberVO getMember(MemberVO mvo);
	public void modifyMember(MemberVO mvo);
	public void deleteMember(MemberVO mvo);
	public int idcheck(String id);
}
