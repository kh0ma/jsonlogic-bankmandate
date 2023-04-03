package com.kh0ma.jsonlogicbankmandate.mvp.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class RequestDataDto {

    private String operation;
    private String currencyCode;
    private BigDecimal amount;
}
