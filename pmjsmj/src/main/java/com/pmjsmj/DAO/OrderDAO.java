package com.pmjsmj.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.MyPageOrderDTO;

@Mapper
public interface OrderDAO {

	List<MyPageOrderDTO> getList(HashMap<String, Object> hash);

	MyPageOrderDTO getItem(MyPageOrderDTO mpoDTO);

	int getAllCount(MemberDTO mdto);

	int deliveringCnt(MemberDTO mdto);

	

}
