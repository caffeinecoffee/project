package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.OrderVO;
import com.example.demo.DTO.ProductVO;
import com.example.demo.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	
	@RequestMapping(value = "orderList")
	public String orderList(HttpServletRequest request, HttpServletResponse response, OrderVO ovo, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("idKey")==null) {
			model.addAttribute("message", "로그인이 필요합니다.");
			model.addAttribute("url", "login");
			return "MsgPage"; 
		}
		List<ProductVO> list = orderService.orderList();
		model.addAttribute("list", list);
		return "OrderList";
	}
}
