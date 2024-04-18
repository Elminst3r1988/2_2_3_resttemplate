package org.example.resttemplate.controller;

import org.example.resttemplate.service.LoanCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanCalculatorService loanCalculatorService;

    @Autowired
    public LoanController(LoanCalculatorService loanCalculatorService) {
        this.loanCalculatorService = loanCalculatorService;
    }

    @GetMapping("/loan")
    public Double calculateLoan(@RequestParam("userId") Long userId) {
        return loanCalculatorService.acceptLoan(userId);
    }
}
