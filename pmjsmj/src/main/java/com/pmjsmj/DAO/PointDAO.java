package com.pmjsmj.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.PointDTO;

@Mapper
public interface PointDAO {
	public PointDTO getPointDTO(MemberDTO mdto);
}
