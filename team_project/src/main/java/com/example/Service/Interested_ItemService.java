package com.example.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.ItemDTO;
import com.example.DTO.PageDTO;

public interface Interested_ItemService {

	public HashMap<String, Object> getItems(HttpServletRequest request, PageDTO pdto);

	public void deleteInterItem(Interested_ItemDTO interDTO, HttpServletRequest request);

	public void selectDeleteInterItem(int[] selectDelete, HttpServletRequest request);

}
