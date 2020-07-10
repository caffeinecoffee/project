package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.AdminDAO;
import com.example.demo.DTO.AdminVO;
import com.example.demo.DTO.MemberVO;
import com.example.demo.service.AdminService;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	AdminDAO adminDAO;
	
	@Override
	public int loginpro(AdminVO avo) {
		return adminDAO.loginpro(avo);
	}

}
