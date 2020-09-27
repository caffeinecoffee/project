package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.ItemDTO;

@Mapper
public interface ItemDAO {

	public List<ItemDTO> getItems(List<Interested_ItemDTO> interestedList);

}
