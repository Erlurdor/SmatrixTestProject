package ru.erlurdor.TestProject.transaction;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.erlurdor.TestProject.security.SecurityHelper;
import ru.erlurdor.TestProject.transaction.pay.PayDto;

import java.util.List;

@Tag(name = "Работа с транзакциями")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Оплата")
    @PostMapping("/pay")
    @Transactional
    public void pay(@RequestBody PayDto payDto) {
        String login = SecurityHelper.getAuthUserLogin();
        transactionService.pay(payDto, login);
    }

    @Operation(summary = "Постраничное получение транзаций")
    @GetMapping("/page")
    @Transactional(readOnly = true)
    public List<TransactionDto> history(@RequestParam int page, @RequestParam int size) {
        String login = SecurityHelper.getAuthUserLogin();
        return transactionService.findPageByLogin(login, page, size);
    }
}
