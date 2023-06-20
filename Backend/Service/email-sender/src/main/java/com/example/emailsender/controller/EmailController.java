package com.example.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailsender.entity.EmailEntity;
import com.example.emailsender.service.EmailSenderService;

@CrossOrigin
@RestController
public class EmailController {

	@Autowired
	private final EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
		
	}
	
	@PostMapping("/send-email")
		public ResponseEntity sendEmail(@RequestBody EmailEntity emailMessage) {
		this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getText());
		return ResponseEntity.ok("Success");
		
	}
}
