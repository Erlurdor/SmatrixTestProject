package ru.erlurdor.TestProject.transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date data;

    @Column(name = "phone_number")
    @Size(min = 11, max = 50)
    private String phoneNumber;

    @Column(name = "sum_transaction")
    private BigDecimal sum;

    @Column(name = "client_id")
    private int clientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public Transaction(Date data, String phoneNumber, BigDecimal sum, int clientId) {
        this.data = data;
        this.phoneNumber = phoneNumber;
        this.sum = sum;
        this.clientId = clientId;
    }

    public Transaction() {
    }
}
