package com.example.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DTO.MemberDTO;
import com.example.DTO.PointDTO;
import com.example.Method.SHA_512Change;
import com.example.Service.MemberService;
import com.example.Service.PointService;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	@ResponseBody
	@PostMapping("loginProc")
	public MemberDTO loginProc(@RequestParam String mem_id, @RequestParam String mem_password, Model model,HttpServletRequest request) {
		MemberDTO mdto = new MemberDTO();
		mdto.setMem_id(mem_id);
		/* mdto.setMem_pas */
		
		try {
			mdto.setMem_password(new SHA_512Change().Change(mem_password));
		} catch (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mdto = memberService.loginProc(mdto);
		if(mdto != null) {
			request.getSession().setAttribute("mdto", mdto);
//			PointDTO pointDTO = pointService.getPointDTO(mdto);
//			request.getSession().setAttribute("pointDTO", pointDTO);
		}
		request.getSession().setAttribute("AccountCheck", false);
		return mdto;
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}
	@ResponseBody
	@GetMapping("/id_check")
	public String id_check(HttpServletRequest request,MemberDTO mdto) {
		System.out.println("idCheck 확인 : "+mdto.toString());
		if(mdto.getMem_name().equals("") || mdto.getMem_email().equals("")) {
			return "";
		}else {
			mdto = memberService.id_check(mdto);
			if(mdto == null) {
				return "실패";
			}else {
				request.getSession().setAttribute("id", mdto.getMem_id());
				return "성공";
			}
		}
	}
	@ResponseBody
	@GetMapping("/pw_check")
	public String pw_check(HttpServletRequest request, MemberDTO mdto) {
		if(mdto.getMem_id().equals("") || mdto.getMem_email().equals("")) {
			return"";
		}else {
			mdto = memberService.pw_Check(mdto,request);
			if(mdto == null) {
				return "실패";
			}else {
				return "성공";
			}
		}
	}
	@ResponseBody
	@PostMapping("/pwCodeCheck")
	public String pwCodeCheck(HttpServletRequest request, String code) {
		String result = memberService.pwCodeCheck(code,request);
		System.out.println("result 확인 : "+result);
		return result;
	}
}
