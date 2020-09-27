package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.PageDTO;
import com.example.DTO.ReviewDTO;
import com.example.DTO.item_inquiryDTO;
import com.example.Service.SangService;

@Controller
public class sang {

	@Autowired
	SangService sangService;

	@RequestMapping(value = { "/index", "/" })
	public String home(HttpServletRequest request, HttpServletResponse response, ItemDTO idto, Model model) {
		List<ItemDTO> popularItem = sangService.popularItem();
		List<ItemDTO> weekPopularItem = sangService.weekPopularItem();
		List<ItemDTO> MDItem = sangService.MDItem();
		model.addAttribute("popularItem", popularItem);
		model.addAttribute("weekPopularItem", weekPopularItem);
		model.addAttribute("MDItem", MDItem);
		return "/index";
	}

	@RequestMapping("/SignUp")
	public String SignUp(HttpServletRequest request) {
		return "/SignUp";
	}

	@RequestMapping("/SignUpProc")
	public String SignUpProc(HttpServletRequest request, MemberDTO mdto) throws NoSuchAlgorithmException {
		String birthYear = request.getParameter("birth-year");
		String birthMonth = request.getParameter("birth-month");
		String birthDay = request.getParameter("birth-day");
		String input = mdto.getMem_password(); // 입력 값
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(input.getBytes());
		byte[] msgb = md.digest();
		for (int i = 0; i < msgb.length; i++) {
			byte temp = msgb[i];
			String str = Integer.toHexString(temp & 0xFF);
			while (str.length() < 2) {
				str = "0" + str;
			}
			str = str.substring(str.length() - 2);
			sb.append(str);
		}
		mdto.setMem_password(sb.toString());
		if (birthYear == null || birthMonth == null || birthDay == null) {
			mdto.setBirth_date(null);
		} else {
			mdto.setBirth_date(birthYear + "/" + birthMonth + "/" + birthDay);
		}

		if (mdto.getMem_email_reception() == null) {
			mdto.setMem_email_reception("0");
		}
		sangService.SignUpProc(mdto);
		return "redirect:/loginPage";
	}

	@ResponseBody
	@RequestMapping("/IDDuplicateCheck")
	public int IDDuplicatecheck(HttpServletRequest request) {
		System.out.println("1");
		String mem_id = request.getParameter("mem_id");
		System.out.println("2");
		int number = sangService.IDDuplicatecheck(mem_id);
		return number;
	}

	@RequestMapping("/shop")
	public String order_select(HttpServletRequest request, ItemDTO idto, PageDTO pdto, Model model) {
		String orderOption = request.getParameter("orderListSelect");
		String category_no = request.getParameter("category_no");
		String search = request.getParameter("search");
		if (category_no == null) {
			category_no = "0";
		}
		if (orderOption == null) {
			orderOption = "1";
		}
		HashMap<String, Object> hash = sangService.getItems(pdto, orderOption, category_no, search);
		model.addAttribute("option", orderOption);
		model.addAttribute("category_no", category_no);
		model.addAttribute("search", search);
		model.addAttribute("list", (List<ItemDTO>) hash.get("list"));
		model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
		return "Shop";
	}

//, ItemOptionDTO iodto, ReviewDTO rdto, QnaDTO qdto
	@RequestMapping("/shopDetail")
	public String ShopDetail(HttpServletRequest request, ItemDTO idto, PageDTO pdto, Model model) {
		String item_no = request.getParameter("item_no");
		idto = sangService.getItem(item_no);
		List<ReviewDTO> reviewList = sangService.getReviews("1", "5", item_no);
		List<item_inquiryDTO> ItemInquiryList = sangService.getItemInquirys("1", "5", item_no);
		List<ItemDTO> likingItemList = sangService.getLikingItems(item_no);
		model.addAttribute("idto", idto);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("ItemInquiryList", ItemInquiryList);
		model.addAttribute("likingItemList", likingItemList);
		return "ShopDetail";
	}

	@RequestMapping("/reviewList")
	public String ReviewList(HttpServletRequest request, ItemDTO idto, PageDTO pdto, Model model) {
		String item_no = idto.getItem_no();
		HashMap<String, Object> hash = sangService.getReviews(pdto, item_no);
		model.addAttribute("reviewList", (List<ReviewDTO>) hash.get("list"));
		model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
		model.addAttribute("item_no", item_no);
		return "ReviewList";
	}
	
	@RequestMapping("/reviewWrite")
	public String ReviewWrite(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException{
		String item_no = request.getParameter("item_no");
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인이 필요합니다.'); location.href='loginPage';</script>");
			writer.flush();
		} else {
			if (sangService.writeQualify(item_no, mdto.getMem_id()) <= 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('구매한 상품만 후기등록이 가능합니다.'); history.back();</script>");
				writer.flush();
			}
		}
		model.addAttribute("item_no", item_no);
		return "ReviewWrite";
	}

	@RequestMapping("/reviewWriteProc")
	public String reviewWriteProc(HttpServletRequest request, ReviewDTO rdto, MemberDTO mdto) {
		// 세션에서 로그인 정보 가져오기 추가해야 함
		mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		String mem_id = mdto.getMem_id();
		if (mem_id == null || mem_id.equals("") || mem_id.length() == 0) {
			return "ReviewWrite";
		} else {
			rdto.setMem_id(mem_id);
			sangService.reviewWriteProc(rdto);
		}
		return "redirect:/reviewList?item_no="+rdto.getItem_no();
	}
	
	@RequestMapping("/ReviewDescribe")
	public String ReviewDescribe(HttpServletRequest request, ReviewDTO rdto, MemberDTO mdto,  Model model) {
		rdto = sangService.ReviewDescribe(rdto);
		model.addAttribute("rdto", rdto);
		return "/ReviewDescribe";
	}
	
	@RequestMapping("/reviewUpdate")
	public String reviewUpdate(HttpServletRequest request, HttpServletResponse response, ReviewDTO rdto, MemberDTO mdto, Model model) throws IOException {
		rdto = sangService.ReviewDescribe(rdto);
		String mem_id = rdto.getMem_id();
		mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인이 필요합니다.'); location.href='loginPage';</script>");
			writer.flush();
		} else {
			String sessMem_id = mdto.getMem_id();
			if (sessMem_id.equals(mem_id)) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('본인이 작성한 글만 수정이 가능합니다.'); location.href='RreviewList?item_no="+rdto.getItem_no()+"';</script>");
				writer.flush();
			}
		}
		model.addAttribute("rdto", rdto);
		return "/ReviewUpdate";
	}
	
	@RequestMapping("/revieUpdateProc")
	public String revieUpdateProc(HttpServletRequest request, ReviewDTO rdto, MemberDTO mdto,  Model model) {
		sangService.revieUpdateProc(rdto);
		return "redirect:/reviewList?item_no="+rdto.getItem_no();
	}

	@RequestMapping("/ItemInquiryList")
	public String ItemInquiryList(HttpServletRequest request, ItemDTO idto, PageDTO pdto, Model model) {
		String item_no = idto.getItem_no();
		HashMap<String, Object> hash = sangService.getItemInquirys(pdto, item_no);
		model.addAttribute("ItemInquiryList", (List<item_inquiryDTO>) hash.get("list"));
		model.addAttribute("pdto", (PageDTO) hash.get("pdto"));
		model.addAttribute("item_no", item_no);
		return "ItemInquiryList";
	}
	
	@RequestMapping("/itemInquiryWrite")
	public String itemInquiryWrite(HttpServletRequest request, ItemDTO idto, Model model) {
		model.addAttribute("item_no", request.getParameter("item_no"));
		return "/itemInquiryWrite";
	}

	@RequestMapping("/itemInquiryWriteproc")
	public String itemInquiryWriteproc(HttpServletRequest request, HttpServletResponse response, item_inquiryDTO indto, Model model) throws IOException {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		String mem_id = mdto.getMem_id();
		if (mem_id == null || mem_id.equals("") || mem_id.length() == 0) {
			return "itemInquiryWrite";
		} else {
			indto.setMem_id(mem_id);
			sangService.itemInquiryWriteProc(indto);
		}
		return "redirect:/ItemInquiryList?item_no="+indto.getItem_no();
	}
	
	@RequestMapping("/itemInquiryDescribe")
	public String itemInquiryDescribe(HttpServletRequest request, item_inquiryDTO indto, Model model) {
		indto = sangService.itemInquiryDescribe(indto);
		model.addAttribute("indto", indto);
		return "/itemInquiryDescribe";
	}
	
	@RequestMapping("/itemInquiryUpdate")
	public String itemInquiryUpdate(HttpServletRequest request, HttpServletResponse response, item_inquiryDTO indto, Model model) throws IOException {
		indto = sangService.itemInquiryDescribe(indto);
		String mem_id = indto.getMem_id();
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인이 필요합니다.'); location.href='loginPage';</script>");
			writer.flush();
		} else {
			String sessMem_id = mdto.getMem_id();
			System.out.println(mem_id);
			System.out.println(sessMem_id);
			System.out.println(!mem_id.equals(sessMem_id));
			System.out.println(mem_id != sessMem_id);
			
			if (!mem_id.equals(sessMem_id)) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('본인이 작성한 글만 수정이 가능합니다.'); location.href='ItemInquiryList?item_no="+indto.getItem_no()+"';</script>");
				writer.flush();
			}
		}
		model.addAttribute("indto", indto);
		return "/itemInquiryUpdate";
	}
	
	@RequestMapping("/itemInquiryUpdateProc")
	public String itemInquiryUpdateProc(HttpServletRequest request, item_inquiryDTO indto, Model model) {
		sangService.itemInquiryUpdateProc(indto);
		return "redirect:/ItemInquiryList?item_no="+indto.getItem_no();
	}
	
	@RequestMapping("signUpEmailCheck")
	public String signUpEmailCheck() {
		return "signUpEmailCheck";
	}
	
	@RequestMapping("addInterestedItem")
	public String addInterestedItem(HttpServletRequest request, HttpServletResponse response, Interested_ItemDTO interDTO, Model model) throws IOException {
		MemberDTO mdto = (MemberDTO)request.getSession().getAttribute("mdto");
		if(mdto == null) {
			return"/login";
		}else {
			interDTO.setMem_id(mdto.getMem_id());
			if (sangService.getInterestedItem(interDTO)) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('이미 추가된 상품 입니다.'); history.back(-1); </script>");
				writer.flush();
			}else {
				sangService.addInterestedItem(interDTO);
			}
		}
		return "redirect:/myInterested";
	}
}