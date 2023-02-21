package ru.erlurdor.TestProject.client.balance;

import java.math.BigDecimal;

public class ClientBalanceDto {
    private String clientLogin;
    private BigDecimal balance;

    public ClientBalanceDto(String clientLogin, BigDecimal balance) {
        this.clientLogin = clientLogin;
        this.balance = balance;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
