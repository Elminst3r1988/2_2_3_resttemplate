package org.example.resttemplate.service;


import org.example.resttemplate.model.User;
import org.example.resttemplate.properties.LoanProperties;
import org.example.resttemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanCalculatorService {
    @Autowired
    private LoanProperties loanProperties;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private UserRepository userRepository;

    public Double acceptLoan(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            double carPrice = (user.getCar() != null) ? user.getCar().getPrice() : 0.0;
            double minCarPrice = loanProperties.getMinimalCarPrice();
            int userIncome = incomeService.getUserIncomeById(userId);
            int minIncome = loanProperties.getMinimalIncome();
            double carLoanCoef = loanProperties.getMaxPercentCarPrice();
            int incomeCoef = loanProperties.getYearIncomeCoef();

            if (carPrice >= minCarPrice || userIncome >= minIncome) {
                double carLoanAmount = carPrice * carLoanCoef;
                double incomeLoanAmount = userIncome * incomeCoef;
                return Math.max(carLoanAmount, incomeLoanAmount);
            }
        }
        return 0.0;
    }
}
