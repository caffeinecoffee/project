package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.TestVO;

@Mapper
public interface TestMapper {

	List<TestVO> selectTestList() throws Exception;
}