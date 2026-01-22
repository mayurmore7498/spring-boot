package com.example.otp.model;

public class OtpData {
	
	private String email;
	
	private String otp;
	
	private Long expiryTime;

	public OtpData(String email, String otp, Long expiryTime) {
		super();
		this.email = email;
		this.otp = otp;
		this.expiryTime = expiryTime;
	}

	public String getEmail() {
		return email;
	}

	public String getOtp() {
		return otp;
	}

	public Long getExpiryTime() {
		return expiryTime;
	}
	
	

}
