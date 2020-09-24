package com.pmjsmj.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.CancelDTO;
import com.pmjsmj.DTO.CartDTO;
import com.pmjsmj.DTO.CartListDTO;
import com.pmjsmj.DTO.ItemDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.MyPageOrderDTO;
import com.pmjsmj.DTO.OrderItemDTO;
import com.pmjsmj.DTO.OrderListDTO;
import com.pmjsmj.DTO.PayBankDTO;
import com.pmjsmj.DTO.PayCardDTO;
import com.pmjsmj.DTO.RefundDTO;
import com.pmjsmj.DTO.RefundListDTO;

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
