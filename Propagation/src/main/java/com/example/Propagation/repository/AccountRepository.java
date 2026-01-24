package com.example.Propagation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Propagation.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
