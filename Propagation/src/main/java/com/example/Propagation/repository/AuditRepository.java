package com.example.Propagation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Propagation.model.AuditLog;

public interface AuditRepository extends JpaRepository<AuditLog, Long> {
}
