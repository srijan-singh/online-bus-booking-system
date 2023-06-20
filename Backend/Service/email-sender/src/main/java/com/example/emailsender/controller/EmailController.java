package com.example.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailsender.entity.EmailEntity;
import com.example.emailsender.service.EmailSenderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmailController {

	@Autowired
	private final EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
		
	}
	
	@PostMapping("/send-email")
		public EmailEntity sendEmail(@RequestBody EmailEntity emailMessage) {
		return this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getText());
		
	}
}
