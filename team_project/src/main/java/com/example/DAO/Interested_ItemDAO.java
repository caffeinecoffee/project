package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.MemberDTO;

@Mapper
public interface Interested_ItemDAO {
	public List<Interested_ItemDTO> getItems(HashMap<String, Object> hash);

	public int deleteInterItem(Interested_ItemDTO interDTO);

	public int selectDeleteInterItem(List<Interested_ItemDTO> list);

	public int getAllCount(MemberDTO mdto);

}
