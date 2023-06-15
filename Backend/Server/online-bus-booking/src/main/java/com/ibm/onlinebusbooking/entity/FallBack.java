package com.ibm.onlinebusbooking.entity;

public class FallBack {
	
	private String serviceName;
	
	private String fallBackMessage;

	public FallBack() {
		this.serviceName = "Essential";
		this.fallBackMessage = "Service is taking longer than Expected. Please try again later";
	}
	
	public FallBack(String serviceName, String fallBackMessage) {
	
		this.serviceName = serviceName;
		this.fallBackMessage = fallBackMessage;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getFallBackMessage() {
		return fallBackMessage;
	}

	public void setFallBackMessage(String fallBackMessage) {
		this.fallBackMessage = fallBackMessage;
	}
	

}
