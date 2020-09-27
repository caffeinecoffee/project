package com.example.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.PointDAO;
import com.example.DTO.MemberDTO;
import com.example.DTO.PointDTO;
import com.example.Service.PointService;

@Service
public class PointServiceImpl implements PointService{
	
	@Autowired
	private PointDAO pointDAO;
	
	@Override
	public PointDTO getPointDTO(MemberDTO mdto) {
		PointDTO pointDTO = pointDAO.getPointDTO(mdto);
		return pointDTO;
	}
	
}
