package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DTO.MemberVO;
import com.example.demo.DTO.ProductVO;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	
	
	
	
	//관리자
	@RequestMapping(value = "/productList")
	public String productList(HttpServletRequest request, HttpServletResponse response, ProductVO pvo, Model model) {
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
	
//	@RequestMapping("/productInsertProc")
//	public String productInsertProc(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam("image2") MultipartFile file, ProductVO pvo, Model model) {
//		
//		HttpSession session = request.getSession();
//		MemberVO adminDto = (MemberVO) session.getAttribute("adminDto");
//		int r = 0;
//		String flag = request.getParameter("flag");
//		String msg = null;
//		String url = null;
//		if(flag.equals("insert")) { //등록
//			r = productService.insertProduct(pvo, file);
//			if(r>0) {
//				msg="상품등록성공";
//				url="/productMgr";
//			}else {
//				msg="상품등록실패";
//				url="/";
//			}
//		}
//		model.addAttribute("msg", msg);
//		model.addAttribute("url", url);
//		session.setAttribute("adminDto", adminDto);
//		return "";
//	}
}
