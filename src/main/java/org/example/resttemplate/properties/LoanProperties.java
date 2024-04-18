package org.example.resttemplate.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loan")
public class LoanProperties {
    private int minimalIncome;
    private int minimalCarPrice;
    private int yearIncomeCoef;
    private Double maxPercentCarPrice;
    private String incomeURL;

    public String getIncomeURL() {
        return incomeURL;
    }

    public void setIncomeURL(String incomeURL) {
        this.incomeURL = incomeURL;
    }

    public int getMinimalIncome() {
        return minimalIncome;
    }

    public void setMinimalIncome(int minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public int getYearIncomeCoef() {
        return yearIncomeCoef;
    }

    public void setYearIncomeCoef(int yearIncomeCoef) {
        this.yearIncomeCoef = yearIncomeCoef;
    }

    public Double getMaxPercentCarPrice() {
        return maxPercentCarPrice;
    }

    public void setMaxPercentCarPrice(Double maxPercentCarPrice) {
        this.maxPercentCarPrice = maxPercentCarPrice;
    }

    public int getMinimalCarPrice() {
        return minimalCarPrice;
    }

    public void setMinimalCarPrice(int minimalCarPrice) {
        this.minimalCarPrice = minimalCarPrice;
    }
}
