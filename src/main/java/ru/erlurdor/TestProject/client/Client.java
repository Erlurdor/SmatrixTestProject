package ru.erlurdor.TestProject.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login_client")
    @Size(min = 11, max = 50)
    private String login;

    @Column(name = "password_client")
    @Size(min = 6, max = 128)
    private String password;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "fio")
    @Size(min = 1, max = 50)
    private String fio;

    @Column(name = "email")
    @Size(min = 1, max = 50)
    private String email;

    @Column(name = "gender")
    @Size(min = 1, max = 50)
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    public Client() {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Client(String login, String password, BigDecimal balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public Client(String login, String password, BigDecimal balance, String fio, String email, String gender, Date birthday) {
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.fio = fio;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
    }
}
