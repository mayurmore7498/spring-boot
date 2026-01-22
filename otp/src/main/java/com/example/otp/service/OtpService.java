package com.example.otp.service;

import com.example.otp.model.OtpData;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OtpService {

    private Map<String, OtpData> otpStorage = new HashMap<>();

    public String generateOtp(String email) {

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        long expiry = System.currentTimeMillis() + (5 * 60 * 1000);

        otpStorage.put(email, new OtpData(email, otp, expiry));

        return otp;
    }

    public boolean verifyOtp(String email, String otp) {

        OtpData data = otpStorage.get(email);

        if (data == null) return false;
        if (System.currentTimeMillis() > data.getExpiryTime()) return false;

        return data.getOtp().equals(otp);
    }
}
