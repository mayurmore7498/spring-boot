package com.example.Propagation.controller;

import com.example.Propagation.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired
    private com.example.Propagation.service.BankService bankService;

    @GetMapping("/transfer")
    public String transfer(
            @RequestParam Long from,
            @RequestParam Long to,
            @RequestParam double amount) {

        bankService.transfer(from, to, amount);
        return "Transfer completed";
    }
}
