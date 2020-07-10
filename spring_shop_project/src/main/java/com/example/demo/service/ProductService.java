package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.MemberVO;
import com.example.demo.DTO.ProductVO;

public interface ProductService {

	List<ProductVO> productMgr();

	int productInsertPro(ProductVO pvo);

}
