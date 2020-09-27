package com.example.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.MemberDTO;
import com.example.DTO.PointDTO;

@Mapper
public interface PointDAO {
	public PointDTO getPointDTO(MemberDTO mdto);
}
