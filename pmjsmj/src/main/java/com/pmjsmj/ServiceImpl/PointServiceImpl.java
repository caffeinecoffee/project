package com.pmjsmj.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmjsmj.DAO.PointDAO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.PointDTO;
import com.pmjsmj.Service.PointService;

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
