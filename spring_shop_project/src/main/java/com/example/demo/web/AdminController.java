package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		return "admin/adminlogin";
	}

	@RequestMapping("/admin/loginpro")
	public String loginpro(HttpServletRequest request, HttpServletResponse response, AdminVO avo, Model model) {
		int a = adminService.loginpro(avo);
		HttpSession session = request.getSession();
		if (a > 0) {
			model.addAttribute("message", "로그인 성공");
			session.setAttribute("idKey", avo.getAdmin_id());
		} else if (a == 0) {
			model.addAttribute("message", "로그인 실패");
		}
		return "admin/index";
	}
}
