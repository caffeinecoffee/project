package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.MemberVO;
import com.example.demo.service.MemberService;

@Controller
public class CustomController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		// 세션을 받아서 회원 정보가 있으면 회원정보를 저장
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("idKey");
		member.setMem_id(mem_id);
		model.addAttribute("member", member);
		return "index";
	}

	@GetMapping("/register")
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "register";
	}
	
	@RequestMapping (value = "idcheck")
	@ResponseBody
	public int idCheck(HttpServletRequest request, HttpServletResponse response, MemberVO member) {
		int cnt = 0;
		String id = member.getMem_id();
		if(member.getMem_id()!=null) {
			cnt = memberService.idcheck(id);
		}
		return cnt;
	}
	
	@RequestMapping (value = "registerPro")
	public String registerPro(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		int a = memberService.registerPro(member);
		if (a>0) {
			model.addAttribute("message", "회원가입 성공");
		}
		return "index";
	}
	
	@RequestMapping (value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		return "login";
	}
	
	@RequestMapping (value = "passwdcheck")
	@ResponseBody
	public int passwdcheck(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		int cnt = 0;
		if(member.getMem_id()!=null) {
			cnt = memberService.passwdcheck(member);
		}
		System.out.println(cnt);
		return cnt;
	}
}
