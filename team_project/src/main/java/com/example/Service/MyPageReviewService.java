package com.example.Service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.DTO.PageDTO;

public interface MyPageReviewService {

	public HashMap<String, Object> getReviews(HttpServletRequest request, PageDTO pdto);

}
