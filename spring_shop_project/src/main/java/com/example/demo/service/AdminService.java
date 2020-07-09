package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AdminVO;
import com.example.demo.DTO.MemberVO;

@Service
public interface AdminService {

	public int loginpro(AdminVO avo);
}
