package com.example.demo.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.MemberVO;
import com.example.demo.DTO.ProductVO;

@Mapper
public interface OrderDAO {

	List<ProductVO> orderList();


}
