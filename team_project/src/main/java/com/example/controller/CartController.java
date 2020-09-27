package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DTO.CancelDTO;
import com.example.DTO.CartDTO;
import com.example.DTO.CartListDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.OrderListDTO;
import com.example.DTO.PageDTO;
import com.example.DTO.PayBankDTO;
import com.example.DTO.PayCardDTO;
import com.example.Service.CartService;
import com.example.ServiceImpl.CartServiceImpl;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;

	// 장바구니 눌렀을때 장바구니로 가지고감
	@RequestMapping("/cartProc")
	public String basketProc(HttpServletRequest request,CartDTO cdto) {
		
		MemberDTO mdto = (MemberDTO)request.getSession().getAttribute("mdto");
		if(mdto == null) {
			return"/login";
		}else {
			String r = cartService.cartCheck(cdto,mdto);
			if(r!=null) {
				return "redirect:/";
			}
			cartService.setCart(cdto,mdto);
		}
		return"redirect:cartDetail";
	}
	//삭제 버튼을 눌렀을 때 장바구니에 있는 상품 삭제
	//(전체 상품 선택하는 거는 안함)(상품이 없을 때 가격 아무것도 안떠야하는데 안됨)
	@RequestMapping("/deleteProc")
	public String deleteProc(HttpServletRequest request, CartDTO cdto) {
		MemberDTO mdto = (MemberDTO)request.getSession().getAttribute("mdto");
		if (mdto ==  null) {
			return"/login";
		}else {
			cartService.delete(mdto, cdto);
		}		
		return "redirect:cartDetail";
		
		//		if (mdto ==  null) {
//			return "/login";
//		}else {
//			cartService.delete(mdto, cldto);			
//		}		
//		return "cartDetail";
		
	}
	// 주문하기 눌렀을때 넘어감
	@RequestMapping("/orderProc")
	public String cartOrder(HttpServletRequest request, Model model) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			return "login";
		} else {//orderlist//cldtoList
			List<CartListDTO> orderlist = cartService.getOrderList(mdto);
			int sum = 0;
			for (int i = 0; i < orderlist.size(); i++) {
				sum = sum + (orderlist.get(i).getCart_cnt() * (orderlist.get(i).getItem_first_price()
						- (orderlist.get(i).getItem_first_price() - orderlist.get(i).getItem_discount())));
			}
			model.addAttribute("orderlist", orderlist);
			request.getSession().setAttribute("sum",sum);
		}
		return "order";
	}
	@ResponseBody
	@PostMapping("itemCount")
	public int itemCount(int cart_cnt,int item_no,int money,String stat,HttpServletRequest request) {
		int sum = cartService.itemCount(cart_cnt,item_no,request,money,stat);
		return sum;
	}
	@RequestMapping("/orderCompleteProc")
	public String orderInfo(HttpServletRequest request, OrderListDTO olDTO, PayCardDTO pcDTO, PayBankDTO pbDTO,Model model) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		
		OrderListDTO resultOlDTO = cartService.orderComplete(olDTO,pcDTO,pbDTO,mdto);
		model.addAttribute("resultOlDTO",resultOlDTO);
		
		return "orderComplete";
	}
	
	@RequestMapping("/orderCancel")
	public String orderCancel(HttpServletRequest request, Model model, CancelDTO cancelDTO,PageDTO pageDTO) {
		
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		System.out.println("오더캔슬 page 확인"+pageDTO.toString());
		cartService.addCancel(cancelDTO,mdto);
			
		return "redirect:myAccount?presentPage="+pageDTO.getPresentPage();
	}
}
