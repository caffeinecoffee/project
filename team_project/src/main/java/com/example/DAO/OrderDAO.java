package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageOrderDTO;

@Mapper
public interface OrderDAO {

	List<MyPageOrderDTO> getList(HashMap<String, Object> hash);

	MyPageOrderDTO getItem(MyPageOrderDTO mpoDTO);

	int getAllCount(MemberDTO mdto);

	int deliveringCnt(MemberDTO mdto);

	

}
