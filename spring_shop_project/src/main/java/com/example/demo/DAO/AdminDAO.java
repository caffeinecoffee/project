package com.example.demo.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.AdminVO;

@Mapper
public interface AdminDAO {

	int loginpro(AdminVO avo);

}
