package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.DTO.MemberVO;
import com.example.demo.DTO.ProductVO;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<ProductVO> productMgr() {
		return productDAO.productList();
	}

	@Override
	public int productInsertPro(ProductVO pvo) {
		return productDAO.productInsertPro(pvo);
	}
}
