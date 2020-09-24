package com.pmjsmj.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmjsmj.DAO.CartDAO;
import com.pmjsmj.DTO.CancelDTO;
import com.pmjsmj.DTO.CartDTO;
import com.pmjsmj.DTO.CartListDTO;
import com.pmjsmj.DTO.ItemDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.OrderItemDTO;
import com.pmjsmj.DTO.OrderListDTO;
import com.pmjsmj.DTO.PayBankDTO;
import com.pmjsmj.DTO.PayCardDTO;
import com.pmjsmj.DTO.RefundDTO;
import com.pmjsmj.DTO.RefundListDTO;
import com.pmjsmj.Service.CartService;
import com.sun.javafx.collections.MappingChange.Map;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO cartDAO;

	@Override
	public void setCart(CartDTO cdto, MemberDTO mdto) {
		cdto.setMem_id(mdto.getMem_id());
		if (cdto.getCart_cnt() == 0) {
			cdto.setCart_cnt(1);
		}
		cartDAO.addCart(cdto);

	}
	

	@Override
	public List<CartListDTO> getCartList(MemberDTO mdto) {
		List<CartListDTO> cldtoList = cartDAO.getCartListDTO(mdto);
//		for(int i=0; i<cldtoList.size();i++) {
//			System.out.println(cldtoList.get(i).toString());
//		}
		return cldtoList;
	}

	@Override
	public void delete(MemberDTO mdto, CartDTO cdto) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("mdto", mdto);
		hash.put("cdto", cdto);
		cartDAO.deleteCart(hash);
	}

	@Override
	public List<CartListDTO> getOrderList(MemberDTO mdto) {
		List<CartListDTO> orderList = cartDAO.cartOrderList(mdto);
		return orderList;
	}

	@Override
	public int itemCount(int cart_cnt, int item_no, HttpServletRequest request,int money,String stat) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		int sum = (Integer)request.getSession().getAttribute("sum");
		System.out.println("sum 확인 :"+sum);
		System.out.println("stat :"+stat);
		if(stat.equals("plus")) {
			sum+=money;
		}else {
			 sum-=money;
		}
		System.out.println("sum1 : "+sum);
		System.out.println("money : "+money);
		System.out.println("sum2 : "+sum);
		
		request.getSession().setAttribute("sum", sum);
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("cart_cnt", cart_cnt);
		hash.put("item_no", item_no);
		hash.put("mdto", mdto);
		
		cartDAO.setItemCount(hash);
		// olDTO.setMem_id(mdto.getNum_id());
		return sum;
	}

	@Override
	public OrderListDTO orderComplete(OrderListDTO olDTO, PayCardDTO pcDTO, PayBankDTO pbDTO, MemberDTO mdto) {
		olDTO.setMem_id(mdto.getMem_id());
		if (!pcDTO.getPay_credit_name().equals("none")) {
			System.out.println("카드결제 : "+pcDTO.getPay_credit_name());
			olDTO.setOrder_status("결제확인");
		} else {
			System.out.println("무통장입금: "+pbDTO.getPay_bank_depositor());
			olDTO.setOrder_status("결제대기");
		}
		List<CartListDTO> orderList = cartDAO.cartOrderList(mdto);
		int sum = 0;
		for (int i = 0; i < orderList.size(); i++) {
			sum = sum + (orderList.get(i).getCart_cnt() * (orderList.get(i).getItem_first_price()
					- (orderList.get(i).getItem_first_price() - orderList.get(i).getItem_discount())));
		}
		olDTO.setOrder_money(sum + 2500);
		Random rand = new Random();
		String numStr = ""; // 난수가 저장될 변수

		for (int i = 0; i < 6; i++) {
			// 0~9 까지 난수 생성
			String ran = Integer.toString(rand.nextInt(10));
			// 중복을 허용하지 않을시 중복된 값이 있는지 검사한다
			if (!numStr.contains(ran)) {
				// 중복된 값이 없으면 numStr에 append
				numStr += ran;
			} else {
				// 생성된 난수가 중복되면 루틴을 다시 실행한다
				i -= 1;
			}
		}
		olDTO.setOrder_tracking_num(numStr);
		int order_no = cartDAO.getOrderNo();
		olDTO.setOrder_no(order_no);
		System.out.println(olDTO.toString());
		cartDAO.addOrderList(olDTO);
	
		if(olDTO.getOrder_pay_option().equals("무통장입금")) {
			pbDTO.setOrder_no(order_no);
			cartDAO.addPayBank(pbDTO);
		}else {
			pcDTO.setOrder_no(order_no);
			cartDAO.addCard(pcDTO);
		}
		
		for(int i=0; i<orderList.size();i++) {
			OrderItemDTO oiDTO = new OrderItemDTO();
			oiDTO.setItem_no(orderList.get(i).getItem_no());
			oiDTO.setOrders_item_cnt(orderList.get(i).getCart_cnt());
			oiDTO.setOrder_no(olDTO.getOrder_no());
			ItemDTO iDTO = cartDAO.getItemInfo(oiDTO.getItem_no());			
			oiDTO.setOrders_item_money(iDTO.getItem_first_price()-(iDTO.getItem_first_price()-iDTO.getItem_discount()));
			
			cartDAO.addOrderItemInfo(oiDTO);
			
		}
		return olDTO;
	}

	@Override
	public List<RefundDTO> getRefund(int order_no, MemberDTO mdto) {
		HashMap<String, Object> hash = new HashMap<>();
		hash.put("order_no", order_no);
		hash.put("mdto", mdto);
		List<RefundDTO> orderRefund = cartDAO.refundList(hash);
		for (int i = 0; i < orderRefund.size(); i++) {
			int discount = orderRefund.get(i).getItem_first_price()-orderRefund.get(i).getItem_discount();
			orderRefund.get(i).setItem_discount(discount);
		}
		
		return orderRefund;
	}

	@Override
	public void addCancel(CancelDTO cancelDTO, MemberDTO mdto) {
		cancelDTO.setAdmin_approval_or_not(0);
		System.out.println("취소 테이블 : "+ cancelDTO.toString());
		cartDAO.addCancelInfo(cancelDTO);
		cartDAO.setOrderStatus(cancelDTO);
	}

	@Override
	public List<RefundListDTO> getRefundList(MemberDTO mdto) {
		//DB에서 가져온 내용
		List<RefundListDTO> rflistDTO = cartDAO.getRefundList(mdto);
		
		//DB에서 가져온 내용 축약해서 데이터 삽입
		// ArrayList는 List를 implements를 받기 때문에 아래와 같이 사용할 수 있다.
		//List<RefundListDTO> result = new ArrayList<>();
		// ArrayList<RefundListDTO> result = new ArrayList<>();
		// 위와 같다
		for(int i=0; i<rflistDTO.size();i++) {
			rflistDTO.get(i).setItem_name(rflistDTO.get(i).getItem_name()+" 등 "+rflistDTO.get(i).getOrders_item_cnt()+"개");

		}
		for(int i=0; i<rflistDTO.size();i++) {
			System.out.println(rflistDTO.get(i).toString());
		}
		return rflistDTO;
	}


	@Override
	public String cartCheck(CartDTO cdto, MemberDTO mdto) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("cdto", cdto);
		hash.put("mdto", mdto);
 		String r = cartDAO.cartCheck(hash);
		return r;
	}	

}
