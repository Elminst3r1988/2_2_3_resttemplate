package org.example.resttemplate.service;


import org.example.resttemplate.model.User;
import org.example.resttemplate.properties.LoanProperties;
import org.example.resttemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanCalculatorService {
    @Autowired
    private LoanProperties loanProperties;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private UserRepository userRepository;

    public Double acceptLoan(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user.getCar().getPrice() >= loanProperties.getMinimalCarPrice() || incomeService.getUserIncomeById(userId) > loanProperties.getMinimalIncome()) {
            double carLoanAmount = user.getCar().getPrice() * loanProperties.getMaxPercentCarPrice();
            double incomeLoanAmount = incomeService.getUserIncomeById(userId) * loanProperties.getYearIncomeCoef();

            return Math.max(carLoanAmount, incomeLoanAmount);
        }

        return 0.0;
    }
}
