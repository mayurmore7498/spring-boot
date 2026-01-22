
package com.example.otp1.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.otp1.model.OtpToken;
import com.example.otp1.repository.OtpRepository;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepo;

    public String generateOtp(String email) {

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        OtpToken token = otpRepo.findByEmail(email)
                .orElse(new OtpToken());

        token.setEmail(email);
        token.setOtp(otp);
        token.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepo.save(token);
        return otp;
    }

    public boolean verifyOtp(String email, String otp) {

        OtpToken token = otpRepo.findByEmail(email).orElse(null);

        if (token == null) return false;
        if (LocalDateTime.now().isAfter(token.getExpiryTime())) return false;

        return token.getOtp().equals(otp);
    }
}
