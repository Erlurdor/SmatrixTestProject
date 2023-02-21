package ru.erlurdor.TestProject.security.token;

import java.time.LocalDateTime;

public class Token {
    private String userLogin;
    private LocalDateTime expirationTime;
    private String tokenString;

    public Token(String userLogin, LocalDateTime expirationTime, String tokenString) {
        this.userLogin = userLogin;
        this.expirationTime = expirationTime;
        this.tokenString = tokenString;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
