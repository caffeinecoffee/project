package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.ProductVO;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	
	
	
	
	//관리자
	@RequestMapping(value = "/productList")
	public String productList(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		HttpSession session = request.getSession();
		List<ProductVO> list = productService.productMgr();
		model.addAttribute("list", list);
		return "productList";
	}
	
	@RequestMapping(value = "/productInsert")
	public String productIns(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		HttpSession session = request.getSession();
		if (pvo.getNo()==0) {
			pvo = new ProductVO();
		}
		if (session.getAttribute("mRole")==null) {
			model.addAttribute("message", "권한이 없습니다.");
			return "MsgPage";
		}
		return "/admin/productInsert";
	}
	
	@RequestMapping(value = "/productInsertPro")
	public String productInsertPro(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mRole")==null) {
			model.addAttribute("message", "권한이 없습니다.");
			return "MsgPage";
		}
		if (pvo.getNo()==0) {
		int a = productService.productInsertPro(pvo);
		if (a>0){
			model.addAttribute("message", "상품이 정상적으로 등록 되었습니다.");
		} else if (a==0) {
			model.addAttribute("message", "상품이 등록되지 않았습니다.");
		}
		model.addAttribute("url", "productMgr");
		} else if (pvo.getNo()!=0) {
			
		}
		return "MsgPage";
	}
}
