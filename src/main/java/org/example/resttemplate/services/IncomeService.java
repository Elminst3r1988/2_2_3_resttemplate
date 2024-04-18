package org.example.resttemplate.services;

import org.example.resttemplate.dto.UserIncomeDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IncomeService {

    public List<UserIncomeDTO> getUserIncomes() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";

        ResponseEntity<List<UserIncomeDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserIncomeDTO>>() {}
        );

        List<UserIncomeDTO> userIncomeDTOS = responseEntity.getBody();

        return userIncomeDTOS;
    }

    public int getUserIncomeById(Long id) {
        for (UserIncomeDTO income : getUserIncomes()) {
            if (income.getId() == id) {
                return income.getIncome();
            }
        }
        return 0;
    }
}
