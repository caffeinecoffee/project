package com.example.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.DTO.CancelDTO;
import com.example.DTO.CartDTO;
import com.example.DTO.CartListDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.OrderListDTO;
import com.example.DTO.PayBankDTO;
import com.example.DTO.PayCardDTO;
import com.example.DTO.RefundDTO;
import com.example.DTO.RefundListDTO;

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
