package com.example.emailsender.service;

import com.example.emailsender.entity.EmailEntity;

public interface EmailSenderService {
	EmailEntity sendEmail(String to, String subject,String text);
}
