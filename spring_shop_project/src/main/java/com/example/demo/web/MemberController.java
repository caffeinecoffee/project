package com.example.demo.web;

import java.util.List;

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
public class MemberController {

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

	@RequestMapping(value = "idcheck")
	@ResponseBody
	public int idCheck(HttpServletRequest request, HttpServletResponse response, MemberVO member) {
		int cnt = 0;
		String id = member.getMem_id();
		if (member.getMem_id() != null) {
			cnt = memberService.idcheck(id);
		}
		return cnt;
	}

	@RequestMapping(value = "registerPro")
	public String registerPro(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		int a = memberService.registerPro(member);
		if (a > 0) {
			model.addAttribute("message", "회원가입 성공");
		}
		return "index";
	}

	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		return "login";
	}

	@RequestMapping(value = "loginPro")
	public String loginPro(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		member = memberService.loginPro(member);
		HttpSession session = request.getSession();
		String url = "/";
		if (member != null) {
			if (member.getM_role() != null) {
				url = "/admin/index";
			}
			model.addAttribute("message", "로그인 성공");
		} else {
			model.addAttribute("message", "아이디 또는 비밀번호가 잘못되었습니다.");
			url = "login";
		}
		if (member != null) {
			session.setAttribute("member", member);
			session.setAttribute("idKey", member.getMem_id());
			session.setAttribute("mRole", member.getM_role());
		}
		session.setAttribute("url", url);
		return "MsgPage";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("idKey");
		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "/memberUpdate")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		if (mvo.getM_role() == null) {
			member = memberService.selectMember(mvo.getMem_id());
		} else if (mvo.getM_role().equals("admin")) {
			member = memberService.selectMember(member.getMem_id());
		}
		model.addAttribute("mvo", member);
		return "memberUpdate";
	}

	@RequestMapping(value = "/memberUpdatePro")
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response, MemberVO member,
			Model model) {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("mRole");
		if (role == null) {
			memberService.memberUpdate(member);
		} else if (role.equals("admin")) {
			memberService.memberUpdate(member);
			return "/admin/index";
		}
		return "index";
	}

	@RequestMapping(value = "/registerWithdrawal")
	public String registerWithdrawal(HttpServletRequest request, HttpServletResponse response, MemberVO member,
			Model model) {
		HttpSession session = request.getSession();
		String mem_id = member.getMem_id();
		String role = (String) session.getAttribute("mRole");
		if (role == null) {
			int a = memberService.registerWithdrawal(mem_id);
			session.invalidate();
		} else if (role.equals("admin")) {
			int a = memberService.registerWithdrawal(mem_id);
			return "/admin/index";
		}
		return "index";
	}
	
	
	
	//관리자
	@RequestMapping(value = "/memberMgr")
	public String memberMgr(HttpServletRequest request, HttpServletResponse response, MemberVO member, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mRole")==null) {
			model.addAttribute("message", "권한이 없습니다.");
			return "MsgPage";
		}
		List<MemberVO> list = memberService.memberMgr();
		model.addAttribute("list", list);
		System.out.println(list.size());
		return "/admin/memberMgr";
	}
}