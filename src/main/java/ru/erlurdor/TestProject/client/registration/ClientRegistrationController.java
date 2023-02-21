package ru.erlurdor.TestProject.client.registration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.erlurdor.TestProject.client.ClientService;

@Tag(name = "Работа с регистрацией клиентов")
@RestController
public class ClientRegistrationController {
    private final ClientService clientService;

    @Autowired
    public ClientRegistrationController(ClientService clientService) {
        this.clientService = clientService;
    }
    @Operation(summary = "Регистрация клиента")
    @PostMapping("/registration")
    @Transactional
    public void registration(@RequestBody ClientRegistrationDto clientRegistrationDto) {
        clientService.save(clientRegistrationDto);
    }
}
