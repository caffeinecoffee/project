package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.OrderDAO;
import com.example.demo.DTO.ProductVO;
import com.example.demo.service.OrderService;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDAO orderDAO;

	@Override
	public List<ProductVO> orderList() {
		return orderDAO.orderList();
	}


}
