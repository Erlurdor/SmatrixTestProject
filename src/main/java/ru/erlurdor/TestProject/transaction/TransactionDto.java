package ru.erlurdor.TestProject.transaction;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDto {
    private int id;

    private Date data;

    private String phoneNumber;

    private BigDecimal sum;

    private int clientId;

    public TransactionDto(int id, Date data, String phoneNumber, BigDecimal sum, int clientId) {
        this.id = id;
        this.data = data;
        this.phoneNumber = phoneNumber;
        this.sum = sum;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
