package com.example.ddd.training;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Currency;
import lombok.Builder;
import lombok.Data;

/**
 * @author vikash.yadav@piramal.com
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    private BigDecimal amount;
    private Currency currency;

    public Price(BigDecimal amount) {
        this.amount = amount;
        this.currency = Currency.getInstance("USD");
    }

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
