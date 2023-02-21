package ru.erlurdor.TestProject.client;

import java.math.BigDecimal;
import java.util.Date;

public class ClientDto {
    private int id;

    private String login;

    private String password;

    private BigDecimal balance;

    private String fio;

    private String email;

    private String gender;

    private Date birthday;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ClientDto(int id, String login, String password, BigDecimal balance, String fio, String email, String gender, Date birthday) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.fio = fio;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
