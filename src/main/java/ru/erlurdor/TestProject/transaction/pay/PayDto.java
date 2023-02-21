package ru.erlurdor.TestProject.transaction.pay;

import java.math.BigDecimal;
import java.util.Date;

public class PayDto {
    private String phoneNumber;

    private BigDecimal sum;

    public PayDto(String phoneNumber, BigDecimal sum, Date date) {
        this.phoneNumber = phoneNumber;
        this.sum = sum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
