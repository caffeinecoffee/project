package com.pmjsmj.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.pmjsmj.DTO.PageDTO;

public interface MyPageItemInquiryService {

	public HashMap<String, Object> getInquirys(HttpServletRequest request, PageDTO pdto);

}
