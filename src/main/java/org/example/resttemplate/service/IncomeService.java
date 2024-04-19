package org.example.resttemplate.service;

import org.example.resttemplate.dto.UserIncomeDTO;
import org.example.resttemplate.properties.LoanProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IncomeService {

    private final RestTemplate restTemplate;
    private final LoanProperties loanProperties;
    @Autowired
    public IncomeService(RestTemplate restTemplate, LoanProperties loanProperties) {
        this.restTemplate = restTemplate;
        this.loanProperties = loanProperties;
    }

    public int getUserIncomeById(Long id) {
        for (UserIncomeDTO income : getUserIncomes()) {
            if (income.getId() == id) {
                return income.getIncome();
            }
        }
        return 0;
    }

    private List<UserIncomeDTO> getUserIncomes() {

        ResponseEntity<List<UserIncomeDTO>> responseEntity = restTemplate.exchange(
                loanProperties.getIncomeURL(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return responseEntity.getBody();
    }
}
