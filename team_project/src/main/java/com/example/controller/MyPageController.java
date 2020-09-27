package com.example.controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.Method.SHA_512Change;
import com.example.Service.Interested_ItemService;
import com.example.Service.MemberService;

@Controller
public class MyPageController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private Interested_ItemService interestedService; 
	

	@ResponseBody
	@PostMapping("myAccountCheck")
	public String myAccountCheck(MemberDTO mdto, HttpServletRequest request) {
		MemberDTO mdtos = (MemberDTO) request.getSession().getAttribute("mdto");
		try {
			mdto.setMem_password(new SHA_512Change().Change(mdto.getMem_password()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mdtos.getMem_id().equals(mdto.getMem_id()) && mdtos.getMem_password().equals(mdto.getMem_password())) {
			System.out.println("같은회원");
			request.getSession().setAttribute("AccountCheck", true);
			return "성공";
		} else {
			System.out.println("다른회원");
			request.getSession().setAttribute("AccountCheck", false);
			return "실패";
		}
	}

	@ResponseBody
	@PostMapping("emailCheck")
	public String emailCheck(@RequestParam("email") String email,HttpServletRequest request) throws AddressException, MessagingException{
		// 네이버일 경우 smtp.naver.com 을 입력합니다. // Google일 경우 smtp.gmail.com 을 입력합니다. String host = "smtp.naver.com"; final String username = "XXXXXXXX"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. final String password = "YYYYYYYY"; //네이버 이메일 비밀번호를 입력해주세요. int port=465; //포트번호 // 메일 내용 String recipient = "WWWWWWW@gmail.com"; //받는 사람의 메일주소를 입력해주세요. String subject = "메일테스트"; //메일 제목 입력해주세요. String body = username+"님으로 부터 메일을 받았습니다."; //메일 내용 입력해주세요. Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 // SMTP 서버 정보 설정 props.put("mail.smtp.host", host); props.put("mail.smtp.port", port); props.put("mail.smtp.auth", "true"); props.put("mail.smtp.ssl.enable", "true"); props.put("mail.smtp.ssl.trust", host); //Session 생성 Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { String un=username; String pw=password; protected javax.mail.PasswordAuthentication getPasswordAuthentication() { return new javax.mail.PasswordAuthentication(un, pw); } }); session.setDebug(true); //for debug Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 mimeMessage.setFrom(new InternetAddress("XXXXXXXX@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음 mimeMessage.setSubject(subject); //제목셋팅 mimeMessage.setText(body); //내용셋팅 Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
		// Google일 경우 smtp.gmail.com 을 입력합니다.
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
		System.out.println("emailCheck : "+email);
		request.getSession().setAttribute("email", email);
		// 메일 내용 
		//"myeongjun1722@naver.com"
		String recipient = email; //받는 사람의 메일주소를 입력해주세요. 
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
		mimeMessage.setFrom(new InternetAddress("kon324@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
		mimeMessage.setSubject(subject); //제목셋팅 
		mimeMessage.setText(body); //내용셋팅
		Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
		System.out.println("emailCode : "+emailCode);
		return "성공";
	}
	
	@ResponseBody
	@PostMapping("emailCheckData")
	public String[] emailCheckNum(HttpServletRequest request,String checkData) {
		String[] result = memberService.emailCheck(request.getSession(),checkData);
		System.out.println("결과 확인 : "+result[0]);
		return result;
	}
	@ResponseBody
	@PostMapping("telUpdate")
	public String telUpdate(String tel,HttpServletRequest request) {
		String result = memberService.updateTel(tel,request.getSession());
		return result;
	}
	@ResponseBody
	@PostMapping("pwChange")
	public String pwChange(String currentPw, String changePw1,HttpServletRequest request) {
		String result = memberService.pwChange(currentPw,changePw1,request.getSession());
		return result;
	}
	@ResponseBody
	@PostMapping("addressChange")
	public String addressChange(MemberDTO mdto,HttpServletRequest request) {
		String result = memberService.addressChange(mdto,request.getSession());
		System.out.println("이메일 변경 result : "+result);
		return result;
	}
	
	@RequestMapping("myInterestedDelete")
	public String myInterested(Interested_ItemDTO interDTO,HttpServletRequest request,int[] selectDelete) {
		if(selectDelete !=null) {
			System.out.println("컨트롤러 받은 값 크기 확인 : "+selectDelete.length);
			interestedService.selectDeleteInterItem(selectDelete,request);
		}else {
			interestedService.deleteInterItem(interDTO,request);	
		}
		return "redirect:myInterested";
	}
}
