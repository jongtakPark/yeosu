package com.exposition.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
@EnableAsync
public class MailService {

	//String에서 제공하는 MailSender
	private final JavaMailSenderImpl mailSender;
	private Map<String, String> checkCode = new HashMap<>();
	
	//인증번호 난수 생성
	public static String createKey() {
		StringBuffer key = new StringBuffer();
	    Random rnd = new Random();
	 
	    for (int i = 0; i < 8; i++) { 
	        int index = rnd.nextInt(3); 
	        switch (index) {
	            case 0:
	                key.append((char) ((int) (rnd.nextInt(26)) + 97));
	                break;
	            case 1:
	                key.append((char) ((int) (rnd.nextInt(26)) + 65));
	                break;
	            case 2:
	                key.append((rnd.nextInt(10)));
	                break;
	            }
	        }
	        return key.toString();
		}
	
	//이메일 발송
	@Async
	public String sendAuthMail(String email) throws MessagingException{
	   String authKey = createKey();
	    checkCode.put("code", authKey);
	    MimeMessage mailMessage = mailSender.createMimeMessage();
	    String mailContent = "인증번호 : "+ authKey ;    
	        mailMessage.setSubject("여수세계섬박람회 회원가입 인증메일", "utf-8"); 
	        mailMessage.setText(mailContent, "utf-8", "html");  
	        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	        mailSender.send(mailMessage); // <--회원가입시 email란에 입력한 이메일주소로 인증메일이 보내진다.
	        
	      return authKey;
	    }
	
	//인증번호 확인
	public boolean checkCode(String emailcode) {
		boolean check = false;
		if(checkCode.get("code").equals(emailcode)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	
}
