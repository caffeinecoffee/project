package com.example.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.DTO.MyPageOrderDTO;
import com.example.DTO.PageDTO;

public interface OrderService {

	HashMap<String, Object> getOrderList(HttpServletRequest request, PageDTO pdto);

	MyPageOrderDTO getOrderItem(MyPageOrderDTO mpoDTO, HttpServletRequest request);

}
