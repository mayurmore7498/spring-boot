package com.example.otp1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp1.model.User;
import com.example.otp1.repository.UserRepository;
import com.example.otp1.service.EmailService;
import com.example.otp1.service.OtpService;

import org.springframework.ui.Model;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    // Open register page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

  
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setEnabled(false);
        userRepo.save(user);

        String otp = otpService.generateOtp(email);
        emailService.sendOtp(email, otp);

        model.addAttribute("email", email);
        return "verify-otp";
    }

  
    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestParam String email,
            @RequestParam String otp,
            Model model) {

        boolean verified = otpService.verifyOtp(email, otp);

        if (!verified) {
            model.addAttribute("error", "Invalid or expired OTP");
            model.addAttribute("email", email);
            return "verify-otp";
        }

        User user = userRepo.findByEmail(email).get();
        user.setEnabled(true);
        userRepo.save(user);

        return "success";
    }
    
    
    @GetMapping("/login")
    public String loginPage() {
    	return "login";
    }
    
    
    @PostMapping("/login")
    public String login(
    		@RequestParam String email,
    		@RequestParam String password,
    		Model model) {
    	User user=userRepo.findByEmail(email).orElse(null);
    	
    	if(user == null ||!user.isEnabled()
    			|| !user.getPassword().equals(password)) {
    		model.addAttribute("error","Invalid email or Password ");
    		return "login";
    	
    	}
    	return "success";
    }

    
    @PostMapping("/resend-otp")
    public String resendOtp(
            @RequestParam String email,
            Model model) {

        String otp = otpService.generateOtp(email);
        emailService.sendOtp(email, otp);

        model.addAttribute("email", email);
        model.addAttribute("message", "OTP resent successfully");
        return "verify-otp";
    }
}
