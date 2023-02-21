package ru.erlurdor.TestProject.client;

import java.util.Date;

public class ClientDataDto {
    private String fio;

    private String email;

    private String gender;

    private Date birthday;

    public ClientDataDto(String fio, String email, String gender, Date birthday) {
        this.fio = fio;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
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
}
