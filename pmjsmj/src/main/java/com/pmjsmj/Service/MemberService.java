package com.pmjsmj.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pmjsmj.DTO.MemberDTO;

public interface MemberService {

	public MemberDTO loginProc(MemberDTO mdto);

	public String[] emailCheck(HttpSession session, String checkData);

	public String updateTel(String tel, HttpSession httpSession);

	public String pwChange(String currentPw, String changePw1, HttpSession httpSession);

	public String addressChange(MemberDTO mdto, HttpSession httpSession);

	public MemberDTO id_check(MemberDTO mdto);

	public MemberDTO pw_Check(MemberDTO mdto, HttpServletRequest request);

	public String pwCodeCheck(String code, HttpServletRequest request);

}
