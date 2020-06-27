package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.TestVO;

public interface TestService {

	List<TestVO> getTestList() throws Exception;
}