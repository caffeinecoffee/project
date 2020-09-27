package com.example.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.DTO.PageDTO;

public interface MyPageItemInquiryService {

	public HashMap<String, Object> getInquirys(HttpServletRequest request, PageDTO pdto);

}
