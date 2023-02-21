package ru.erlurdor.TestProject.security.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {
    private final SecretKey secretKey;
    private final long expirationTime;

    public TokenService(@Value("${app.token.secret}") String secret,
                        @Value("${app.token.expiration}") long expirationTime) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationTime = expirationTime;
    }

    public Token generateToken(String login) {
        LocalDateTime expirationTime = LocalDateTime.now().plusSeconds(this.expirationTime);
        String tokenString = Jwts.builder()
                .claim("userLogin", login)
                .setExpiration(Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(secretKey)
                .compact();
        return new Token(login, expirationTime, tokenString);
    }

    public String validateToken(String tokenString) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(tokenString);
            LocalDateTime expirationTime = claims.getBody().getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            if (expirationTime.isBefore(LocalDateTime.now())) {
                return null;
            }
            return claims.getBody().get("userLogin", String.class);
        } catch (JwtException e) {
            return null;
        }
    }
}
