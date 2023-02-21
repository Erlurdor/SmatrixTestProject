package ru.erlurdor.TestProject.transaction;

import ru.erlurdor.TestProject.transaction.pay.PayDto;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    Transaction pay(PayDto payDto, String login);

    List<TransactionDto> findPageByLogin(String login, int page, int size);
}
