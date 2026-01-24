package com.example.Propagation.service;

import com.example.Propagation.model.AuditLog;
import com.example.Propagation.repository.AuditRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AuditService {

    @Autowired
    private AuditRepository repo;

    @Transactional(Propagation = Propagation.REQUIRES_NEW)
    public void log(String msg) {

        AuditLog log = new AuditLog();
        log.setMessage(msg);
        repo.save(log);
    }
}
