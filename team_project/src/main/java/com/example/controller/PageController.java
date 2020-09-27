package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DTO.CartListDTO;
import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageOrderDTO;
import com.example.DTO.PageDTO;
import com.example.DTO.RefundDTO;
import com.example.DTO.RefundListDTO;
import com.example.Service.CartService;
import com.example.Service.Interested_ItemService;
import com.example.Service.MyPageItemInquiryService;
import com.example.Service.MyPageReviewService;
import com.example.Service.OrderService;
import com.example.Service.SangService;

@Controller
public class PageController {

	@Autowired
	SangService sangService;
	@Autowired
	Interested_ItemService interestedService;
	@Autowired
	OrderService orderService;
	@Autowired
	MyPageReviewService myPageReviewService;
	@Autowired
	MyPageItemInquiryService myPageItemInquiryService;
	@Autowired
	CartService cartService;

	// 로그인 페이지
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	// 마이페이지 쿠폰 리스트
	@RequestMapping("/myCouponList")
	public String myCouponList() {
		return "myCouponList";
	}

	// 아이디/비밀번호 팝업창
	@RequestMapping("/findPop")
	public String findPop() {
		return "findPop";
	}

	// 리뷰 확인 08-24 수정
	@RequestMapping("/myReviewCheck")
	public String myQandACheck(HttpServletRequest request, Model model, PageDTO pdto) {
		if (request.getSession().getAttribute("mdto") == null) {
			return "redirect:loginPage";
		}
		HashMap<String, Object> hash = myPageReviewService.getReviews(request, pdto);
		model.addAttribute("hash", hash);
		return "myReviewCheck";
	}

	// 상품문의 08-24 추가
	@RequestMapping("/myItemInquiry")
	public String myItemInquiry(HttpServletRequest request, PageDTO pdto, Model model) {
		if (request.getSession().getAttribute("mdto") == null) {
			return "redirect:loginPage";
		}
		HashMap<String, Object> hash = myPageItemInquiryService.getInquirys(request, pdto);
		model.addAttribute("hash", hash);
		return "myItemInquiry";
	}

	// 마이페이지 첫 페이지 0819수정
	@RequestMapping("/myAccount")
	public String myPage(HttpServletRequest request, Model model, PageDTO pdto) {
		if (request.getSession().getAttribute("mdto") == null) {
			return "redirect:loginPage";
		}
		HashMap<String, Object> hash = orderService.getOrderList(request, pdto);
		model.addAttribute("hash", hash);
		return "my-account";
	}

	// 마이페이지 내 관심목록 08-17 수정
	@RequestMapping("myInterested")
	public String myInterested(HttpServletRequest request, Model model, PageDTO pdto) {
		if (request.getSession().getAttribute("mdto") == null) {
			return "redirect:loginPage";
		}
		HashMap<String, Object> hash = interestedService.getItems(request, pdto);

		model.addAttribute("hash", hash);
		return "my-account-interested_item";
	}

	@RequestMapping("emailCheck")
	public String emailCheck() {
		return "emailCheck";
	}

	// 마이페이지 내 정보 확인
	@RequestMapping("InformationCheck")
	public String InformationCheck(HttpServletRequest request) {
		System.out.println("Check 확인 : " + request.getSession().getAttribute("AccountCheck"));
		if (request.getSession().getAttribute("AccountCheck") != null) {
			boolean accountCheck = (Boolean) request.getSession().getAttribute("AccountCheck");
			if (accountCheck == true) {
				return "InformationUpdate";
			} else {
				return "InformationCheck";
			}
		} else {
			return "InformationCheck";
		}

	}

	// 마이페이지 내 정보 업데이트
	@RequestMapping("InformationUpdate")
	public String InformationUpdate(HttpServletRequest request) {
		if (request.getSession().getAttribute("AccountCheck") != null) {
			boolean accountCheck = (Boolean) request.getSession().getAttribute("AccountCheck");
			if (accountCheck == true) {
				request.getSession().setAttribute("AccountCheck", false);
				return "InformationUpdate";
			} else {
				return "InformationCheck";
			}
		} else {
			return "InformationCheck";
		}

	}

	// 마이페이지 택배 확인 0820수정
	@RequestMapping("deliveryTracking")
	public String deliveryTracking(MyPageOrderDTO mpoDTO, HttpServletRequest request, Model model) {
		MyPageOrderDTO result = orderService.getOrderItem(mpoDTO, request);
		if (result == null) {
			return "redirect:index";
		}
		model.addAttribute("mpoDTO", result);
		return "delivery_tracking";
	}

	@RequestMapping("/signUp")
	public String signUp() {
		return "SignUp";
	}

	// 장바구니 상세(화면단 o)
	// 가져온 장바구니 정보를 뿌려줌
	@RequestMapping("/cartDetail")
	public String cartDetail(HttpServletRequest request, Model model) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			return "login";
		} else {
			List<CartListDTO> cldtoList = cartService.getCartList(mdto);
			int sum = 0;
			for (int i = 0; i < cldtoList.size(); i++) {
				sum = sum + (cldtoList.get(i).getCart_cnt() * (cldtoList.get(i).getItem_first_price()
						- (cldtoList.get(i).getItem_first_price() - cldtoList.get(i).getItem_discount())));
			}
			request.getSession().setAttribute("sum", sum);;
			model.addAttribute("cldtoList", cldtoList);
		}
		return "cartDetail";
	}

//			주문결제(화면단 o, 수정필요)
//			@RequestMapping("/order")
//			public String order(HttpServletRequest request, Model model, OrderListDTO oldto) {
//				MemberDTO  mdto = (MemberDTO)request.getSession().getAttribute("mdto");
//				if (mdto==null) {
//					return "login";
//				}else {
//					cartService.getOrderInfo(mdto, oldto);
//				}			
//				
//				return "order";	
//			}

//			주문완료(화면단 o)
	@RequestMapping("/orderComplete")
	public String orderComplete() {
		return "orderComplete";
	}

//			주문결제 취소(화면단 o,수정필요)
	@RequestMapping("/orderRefund")
	public String orderRefund(HttpServletRequest request, Model model, int order_no, PageDTO pageDTO) {
		System.out.println("페이지 확인 : " + pageDTO.toString());
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto == null) {
			return "login";
		} else {
			List<RefundDTO> orderRefund = cartService.getRefund(order_no, mdto);
			if (orderRefund.get(0).getOrder_pay_option().equals("무통장입금")) {
				model.addAttribute("pay_option", "통장입금");
			} else {
				model.addAttribute("pay_option", "신용카드");
			}
			int refundSum = 2500;
			for (int i = 0; i < orderRefund.size(); i++) {
				refundSum = refundSum + (orderRefund.get(i).getOrders_item_cnt()
						* (orderRefund.get(i).getItem_first_price() - orderRefund.get(i).getItem_discount()));
			}
			model.addAttribute("orderRefund", orderRefund);
			model.addAttribute("refundSum", refundSum);
			model.addAttribute("order_no", order_no);
			model.addAttribute("pdto", pageDTO);
		}

		return "orderRefund";
	}

//			환불내역()
	@RequestMapping("/refundList")
	public String refundList(HttpServletRequest request, Model model) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		List<RefundListDTO> rflistDTO = cartService.getRefundList(mdto);
		model.addAttribute("rflistDTO", rflistDTO);
		return "refundList";
	}
}
