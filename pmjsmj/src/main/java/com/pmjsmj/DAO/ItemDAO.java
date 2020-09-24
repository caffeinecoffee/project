package com.pmjsmj.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.Interested_ItemDTO;
import com.pmjsmj.DTO.ItemDTO;

@Mapper
public interface ItemDAO {

	public List<ItemDTO> getItems(List<Interested_ItemDTO> interestedList);

}
