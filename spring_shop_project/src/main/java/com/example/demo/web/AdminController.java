package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.AdminVO;
import com.example.demo.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/admin/index")
	public String adminLogin(HttpServletRequest request, HttpServletResponse response, AdminVO avo, Model model) {
		return "admin/index";
	}
}
