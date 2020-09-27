package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.CancelDTO;
import com.example.DTO.CartDTO;
import com.example.DTO.CartListDTO;
import com.example.DTO.ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageOrderDTO;
import com.example.DTO.OrderItemDTO;
import com.example.DTO.OrderListDTO;
import com.example.DTO.PayBankDTO;
import com.example.DTO.PayCardDTO;
import com.example.DTO.RefundDTO;
import com.example.DTO.RefundListDTO;

@Mapper
public interface CartDAO {

	void addCart(CartDTO cdto);

	List<CartListDTO> getCartListDTO(MemberDTO mdto);

	void deleteCart(HashMap<String, Object> hash);

	List<CartListDTO> cartOrderList(MemberDTO mdto);

	void setItemCount(HashMap<String, Object> hash);

	int getOrderNo();

	void addOrderList(OrderListDTO olDTO); 

	void addPayBank(PayBankDTO pbDTO);

	void addCard(PayCardDTO pcDTO);

	void addOrderItem(CartListDTO cartListDTO);

	ItemDTO getItemInfo(int item_no);

	void addOrderItemInfo(OrderItemDTO oiDTO);

	List<RefundDTO> refundList(HashMap<String, Object> hash);

	void addCancelInfo(CancelDTO cancelDTO);

	void setOrderStatus(CancelDTO cancelDTO);

	List<RefundListDTO> getRefundList(MemberDTO mdto);

	String cartCheck(HashMap<String, Object> hash);

	





	


}
