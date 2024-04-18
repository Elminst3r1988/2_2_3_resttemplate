package org.example.resttemplate.services;


import org.example.resttemplate.dao.UserDao;
import org.example.resttemplate.model.User;
import org.example.resttemplate.properties.LoanProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanCalculatorService {
    @Autowired
    private LoanProperties loanProperties;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private UserDao userDao;

    public Double acceptLoan(Long user_id) {
        User user = userDao.getUserById(user_id);
        if (user.getCar().getPrice() >= loanProperties.getMinimalCarPrice() || incomeService.getUserIncomeById(user_id) > loanProperties.getMinimalIncome()) {
            double carLoanAmount = user.getCar().getPrice() * loanProperties.getMaxPercentCarPrice();
            double incomeLoanAmount = incomeService.getUserIncomeById(user_id) * loanProperties.getYearIncomeCoef();

            return Math.max(carLoanAmount, incomeLoanAmount);
        }

        return 0.0;
    }
}
