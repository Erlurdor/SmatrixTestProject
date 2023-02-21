package ru.erlurdor.TestProject.client;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.erlurdor.TestProject.client.balance.ClientBalanceDto;
import ru.erlurdor.TestProject.security.SecurityHelper;

@Tag(name = "Работа с клиентами")
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Получение баланса клиента")
    @GetMapping("/balance")
    @Transactional(readOnly = true)
    public ClientBalanceDto getBalance() {
        String login = SecurityHelper.getAuthUserLogin();
        return clientService.findBalance(login);
    }

    @Operation(summary = "Редактирование информации о клиенте", description = "ФИО, email, пол и дату рождения")
    @PostMapping("/edit")
    @Transactional
    public void editClient(@RequestBody ClientDataDto clientDataDto) {
        String login = SecurityHelper.getAuthUserLogin();
        clientService.save(clientDataDto, login);
    }
}
