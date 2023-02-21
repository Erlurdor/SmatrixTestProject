package ru.erlurdor.TestProject.transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    static public TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getData(),
                transaction.getPhoneNumber(),
                transaction.getSum(),
                transaction.getClientId()
        );
    }

    static public List<TransactionDto> toDtoList(List<Transaction> transactions) {
        return transactions.stream().map(TransactionMapper::toDto).collect(Collectors.toList());
    }
}
