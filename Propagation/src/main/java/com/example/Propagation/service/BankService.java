package com.example.Propagation.service;

import com.example.Propagation.model.Account;
import com.example.Propagation.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private com.example.Propagation.repository.AccountRepository accountRepo;

    @Autowired
    private AuditService auditService;

    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {

        com.example.Propagation.model.Account from = accountRepo.findById(fromId).get();
        com.example.Propagation.model.Account to = accountRepo.findById(toId).get();

        from.setBalance(from.getBalance() - amount);
        accountRepo.save(from);

        auditService.log("Money deducted from account " + fromId);

        // simulate failure
        if (amount > 5000) {
            throw new RuntimeException("Transfer failed");
        }

        to.setBalance(to.getBalance() + amount);
        accountRepo.save(to);

        auditService.log("Money added to account " + toId);
    }
}
