package com.example.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.service.EmailService;
import com.example.otp.service.OtpService;

@RestController
@RequestMapping("/otp")
public class OtpController {

	@Autowired
	private OtpService optService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public String sendOtp(@RequestParam String email) {
		String otp=optService.generateOtp(email);
		emailService.sendOtp(email, otp);

		return "otp sent to email";
	}
	
	 @PostMapping("/verify")
	    public String verifyOtp(
	            @RequestParam String email,
	            @RequestParam String otp) {

	        boolean result = optService.verifyOtp(email, otp);

	        return result ? "OTP verified successfully ✅" : "Invalid or expired OTP ❌";
	    }
	
	
}
