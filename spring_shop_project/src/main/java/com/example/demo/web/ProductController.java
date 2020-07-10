package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/productMgr")
	public String productMgr(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		List<ProductVO> list = productService.productMgr();
		model.addAttribute("list", list);
		return "/admin/productMgr";
	}
	
	@RequestMapping(value = "/productInsert")
	public String productIns(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		return "/admin/productInsert";
	}
	
	@RequestMapping(value = "/productInsertPro")
	public String productInsertPro(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
		int a = productService.productInsertPro(pvo);
		if (a>0){
			model.addAttribute("message", "상품이 정상적으로 등록 되었습니다.");
		} else if (a==0) {
			model.addAttribute("message", "상품이 등록되지 않았습니다.");
		}
		return "/admin/productInsert";
	}
}
