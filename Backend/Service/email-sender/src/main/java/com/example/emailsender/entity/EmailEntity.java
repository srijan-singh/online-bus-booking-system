package com.example.emailsender.entity;

public class EmailEntity {

	private String to;
	private String subject;
	private String text;
	
	public EmailEntity(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public EmailEntity() {
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
