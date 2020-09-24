package com.pmjsmj.ServiceImpl;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmjsmj.DAO.MemberDAO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.Method.SHA_512Change;
import com.pmjsmj.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberDTO loginProc(MemberDTO mdto) {
		mdto = memberDAO.loginProc(mdto);
		if(mdto != null) {
			memberDAO.updateLastLogin(mdto);
			mdto = memberDAO.loginProc(mdto);
			System.out.println(mdto.toString());
		}
		return mdto;
	}

	@Override
	public String[] emailCheck(HttpSession session, String checkData) {
		System.out.println("checkData : "+checkData);
		String emailCode = (String)session.getAttribute("emailCode");
		System.out.println("emailCode : " +emailCode);
		if(checkData.equals(emailCode)) {
			session.removeAttribute("emailCode");
			MemberDTO mdto = (MemberDTO)session.getAttribute("mdto");
			String email = (String)session.getAttribute("email");
			System.out.println("이메일 확인 : "+email);
			mdto.setMem_email(email);
			System.out.println("데이터 값 확인하기 : "+ mdto.toString());
			memberDAO.emailChange(mdto);
			session.setAttribute("mdto", mdto);
			String[] result = {"같음",email};
			return result;
		}else {
			String[] result = {"틀림"};
			return result;
		}
	}

	@Override
	public String updateTel(String tel,HttpSession session) {
		MemberDTO mdto = (MemberDTO)session.getAttribute("mdto");
		mdto.setMem_mobile(tel);
		memberDAO.updateTel(mdto);
		return mdto.getMem_mobile();
	}

	@Override
	public String pwChange(String currentPw, String changePw1, HttpSession session) {
		MemberDTO mdto = (MemberDTO) session.getAttribute("mdto");
		String result = null;
		try {
			currentPw = new SHA_512Change().Change(currentPw);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(mdto.getMem_password().equals(currentPw)) {
			result = "같음";
			
			try {
				mdto.setMem_password(new SHA_512Change().Change(changePw1));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			memberDAO.updatePw(mdto);
			session.setAttribute("mdto", mdto);
		}else {
			result = "다름";
		}
		return result;
	}

	@Override
	public String addressChange(MemberDTO mdto,HttpSession session) {
		MemberDTO sessionMdto = (MemberDTO)session.getAttribute("mdto");
		sessionMdto.setMem_address(mdto.getMem_address());
		sessionMdto.setMem_address_detail(mdto.getMem_address_detail());
		sessionMdto.setMem_zipcode(mdto.getMem_zipcode());
		System.out.println("주소 변경 확인 : " + sessionMdto.toString());
		int r = memberDAO.updateAddress(sessionMdto);
		if(r>0) {
			return "성공";
		}else {
			return "실패";
		}
		
	}

	@Override
	public MemberDTO id_check(MemberDTO mdto){
		MemberDTO mdtoResult = memberDAO.id_check(mdto);
		if(mdtoResult == null) {
			mdto = null;
		}else {
			String host = "smtp.naver.com"; 

			final String username = "kon324"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
			final String password = "soldesk123"; //네이버 이메일 비밀번호를 입력해주세요.
			//아이디 막 보고 로그인 하시면 안되요 ㅠㅠㅠ
			
			int port=465; //포트번호 
			
			Random rnd =new Random();
			// 메일 내용 
			//"myeongjun1722@naver.com"
			String recipient = mdtoResult.getMem_email(); //받는 사람의 메일주소를 입력해주세요. 
			String subject = "쇼핑몰 아이디 입니다"; //메일 제목 입력해주세요. 
			String body = "아이디 : "+mdtoResult.getMem_id(); //메일 내용 입력해주세요. 
			
			Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 

			// SMTP 서버 정보 설정 
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host); 

			//Session 생성
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			 return new javax.mail.PasswordAuthentication(un, pw);
			} }); 
			session.setDebug(true); //for debug
			Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
			try {
				mimeMessage.setFrom(new InternetAddress("kon324@naver.com"));//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
				mimeMessage.setSubject(subject); //제목셋팅 
				mimeMessage.setText(body); //내용셋팅
				Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println("전송 내용 : "+body);
		}
		
		return mdto;
	}

	@Override
	public MemberDTO pw_Check(MemberDTO mdto,HttpServletRequest request) {
		mdto = memberDAO.pwCheck(mdto);
		if(mdto == null) {
			return null;
		}else {
			String host = "smtp.naver.com"; 

			final String username = "kon324"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
			final String password = "soldesk123"; //네이버 이메일 비밀번호를 입력해주세요.
			//아이디 막 보고 로그인 하시면 안되요 ㅠㅠㅠ
			
			int port=465; //포트번호 
			
			Random rnd =new Random();

			StringBuffer buf =new StringBuffer();

			for(int i=0;i<10;i++){
			    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
			    if(rnd.nextBoolean()){
			        buf.append((char)((int)(rnd.nextInt(26))+97));
			    }else{
			        buf.append((rnd.nextInt(10)));
			    }
			}
			String emailCode = buf.toString();
			request.getSession().setAttribute("emailCode", emailCode);
			request.getSession().setAttribute("id", mdto.getMem_id());
			// 메일 내용 
			//"myeongjun1722@naver.com"
			String recipient = mdto.getMem_email(); //받는 사람의 메일주소를 입력해주세요. 
			String subject = "이메일 인증번호 입니다."; //메일 제목 입력해주세요. 
			String body = "이메일 인증번호 : "+emailCode; //메일 내용 입력해주세요. 
			
			Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 

			// SMTP 서버 정보 설정 
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host); 

			//Session 생성
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			 return new javax.mail.PasswordAuthentication(un, pw);
			} }); 
			session.setDebug(true); //for debug
			Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
			try {
				mimeMessage.setFrom(new InternetAddress("kon324@naver.com"));//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
				mimeMessage.setSubject(subject); //제목셋팅 
				mimeMessage.setText(body); //내용셋팅
				Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} 			
			System.out.println("emailCode : "+emailCode);
		}
		return mdto;
	}

	@Override
	public String pwCodeCheck(String code, HttpServletRequest request) {
		System.out.println("이메일 인증 코드 확인 : "+code);
		String sessionCode = (String)request.getSession().getAttribute("emailCode");
		System.out.println("세션코드 확인 : " + sessionCode);
		if(sessionCode.equals(code)) {
			String input = null;
			request.getSession().removeAttribute("emailCode");
			try {
				Random rnd =new Random();
				StringBuffer buf =new StringBuffer();
				for(int i=0;i<8;i++){
				    if(rnd.nextBoolean()){
				        buf.append((char)((int)(rnd.nextInt(26))+97));
				    }else{
				        buf.append((rnd.nextInt(10))); 
				    }
				}
				input = buf.toString(); //입력 값
				String output = new SHA_512Change().Change(input);
			    MemberDTO mdto = new MemberDTO();
			    mdto.setMem_id((String)request.getSession().getAttribute("id"));
			    mdto.setMem_password(output);
			      
			      memberDAO.updatePw(mdto);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return input;
		}else {
			return "실패";
		}
	}
}
