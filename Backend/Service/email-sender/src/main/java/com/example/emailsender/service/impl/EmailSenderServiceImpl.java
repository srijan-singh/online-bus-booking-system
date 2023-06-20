package com.example.emailsender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.emailsender.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private final JavaMailSender mailSender;
	

	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("busyatraabooking@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		
		
		this.mailSender.send(simpleMailMessage);
	}
	
	

	
}
