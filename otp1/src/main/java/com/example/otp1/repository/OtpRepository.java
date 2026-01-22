package com.example.otp1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.otp1.model.OtpToken;

public interface OtpRepository extends JpaRepository<OtpToken, Long> {
    Optional<OtpToken> findByEmail(String email);
}

