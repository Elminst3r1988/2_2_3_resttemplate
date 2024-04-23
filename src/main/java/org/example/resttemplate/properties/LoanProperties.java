package org.example.resttemplate.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loan")
@Data
public class LoanProperties {
    private int minimalIncome;
    private int minimalCarPrice;
    private int yearIncomeCoef;
    private Double maxPercentCarPrice;
}
