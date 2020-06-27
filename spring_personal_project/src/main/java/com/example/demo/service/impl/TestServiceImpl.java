package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import com.example.demo.vo.TestVO;

@Service
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper testDao;
	
	@Override
	public List<TestVO> getTestList() throws Exception {
		return testDao.selectTestList();
	}	
}