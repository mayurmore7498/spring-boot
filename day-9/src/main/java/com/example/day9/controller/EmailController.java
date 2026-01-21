package com.example.day9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day9.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/send")
	public String sendMail(
			@RequestParam String to,
			@RequestParam String subject,
			@RequestParam String body
			) {
		
		emailService.sendEmail(to, subject, body);
		return "Email sent sucesfully";
		
	}
	
	
	
	

	
	
}
