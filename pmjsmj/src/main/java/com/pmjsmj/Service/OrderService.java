package com.pmjsmj.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.pmjsmj.DTO.MyPageOrderDTO;
import com.pmjsmj.DTO.PageDTO;

public interface OrderService {

	HashMap<String, Object> getOrderList(HttpServletRequest request, PageDTO pdto);

	MyPageOrderDTO getOrderItem(MyPageOrderDTO mpoDTO, HttpServletRequest request);

}
