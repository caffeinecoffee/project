package com.pmjsmj.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.pmjsmj.DTO.PageDTO;

public interface MyPageReviewService {

	public HashMap<String, Object> getReviews(HttpServletRequest request, PageDTO pdto);

}
