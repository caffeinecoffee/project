package com.pmjsmj.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pmjsmj.DTO.CancelDTO;
import com.pmjsmj.DTO.CartDTO;
import com.pmjsmj.DTO.CartListDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.OrderListDTO;
import com.pmjsmj.DTO.PayBankDTO;
import com.pmjsmj.DTO.PayCardDTO;
import com.pmjsmj.DTO.RefundDTO;
import com.pmjsmj.DTO.RefundListDTO;

public interface CartService {

	void setCart(CartDTO cartDTO, MemberDTO mdto);

	List<CartListDTO> getCartList(MemberDTO mdto);

	void delete(MemberDTO mdto, CartDTO cdto);

	List<CartListDTO> getOrderList(MemberDTO mdto);

	int itemCount(int count, int item_no, HttpServletRequest request,int money, String stat);

	OrderListDTO orderComplete(OrderListDTO olDTO, PayCardDTO pcDTO, PayBankDTO pbDTO, MemberDTO mdto);

	List<RefundDTO> getRefund(int order_no, MemberDTO mdto);

	void addCancel(CancelDTO cancelDTO, MemberDTO mdto);

	List<RefundListDTO> getRefundList(MemberDTO mdto);

	String cartCheck(CartDTO cdto, MemberDTO mdto);

	
	





}
