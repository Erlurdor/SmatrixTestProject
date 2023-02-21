package ru.erlurdor.TestProject.security;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.erlurdor.TestProject.security.token.Token;
import ru.erlurdor.TestProject.security.token.TokenService;

@Tag(name = "Работа с авторизацией")
@RestController
public class LoginController {
    private final TokenService tokenService;

    @Autowired
    public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Operation(summary = "Получение токена пользователя")
    @PostMapping("/login")
    @Transactional(readOnly = true)
    public Token login() {
        return tokenService.generateToken(SecurityHelper.getAuthUserLogin());
    }
}
