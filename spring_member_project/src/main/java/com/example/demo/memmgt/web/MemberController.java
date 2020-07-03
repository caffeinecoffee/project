package com.example.demo.memmgt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.memmgt.dto.MemberVO;
import com.example.demo.memmgt.dto.PageVO;
import com.example.demo.memmgt.service.SignService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private SignService signService;

	@RequestMapping(value = "/signForm.sa")
	public String signForm(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		return "memmgt/signForm";
	}

	@RequestMapping(value = "/signPro.sa")
	public String signPro(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		int r = signService.DataSave(mvo);
		if (r > 0) {
			model.addAttribute("message", "ȸ�������� �����Ͽ����ϴ�.");
		} else {
			model.addAttribute("message", "ȸ�������� �����Ͽ����ϴ�.");
		}
		return "memmgt/signPro";
	}
	
	@RequestMapping(value = "/memberList.sa")
	public String memberList(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		List<MemberVO> list = signService.getMembers(pvo);
		model.addAttribute("pvo", pvo);
		model.addAttribute("list", list);
		return "memmgt/memberList";
	}
	
	@RequestMapping (value = "memberInformation.sa")
	public String memberInformation(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		mvo = signService.getMember(mvo);
		model.addAttribute("pvo", pvo);
		model.addAttribute("mvo", mvo);
		return "memmgt/memberInformation";
	}
	
	@RequestMapping (value = "membermodify.sa")
	public String memberModify(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		mvo = signService.modifyMember(mvo);
		return "redirect:/memberList.sa";
	}
	
	@RequestMapping (value = "memberdelete.sa")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response, Model model, PageVO pvo,
			MemberVO mvo) {
		signService.memberDelete(mvo);
		return "redirect:/memberList.sa";
	}
	
	@RequestMapping (value = "idcheck.sa")
	@ResponseBody
	public int idCheck(MemberVO mvo, HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		String id = mvo.getMemId();
		if(mvo.getMemId()!=null) {
			cnt = signService.idcheck(id);
		}
		return cnt;
	}
}
