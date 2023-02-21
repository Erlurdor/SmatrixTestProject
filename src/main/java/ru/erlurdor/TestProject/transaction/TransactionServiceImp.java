package ru.erlurdor.TestProject.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.erlurdor.TestProject.client.Client;
import ru.erlurdor.TestProject.client.ClientService;
import ru.erlurdor.TestProject.transaction.pay.PayDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ClientService clientService;

    @Autowired
    public TransactionServiceImp(TransactionRepository transactionRepository, ClientService clientService) {
        this.transactionRepository = transactionRepository;
        this.clientService = clientService;
    }

    @Override
    public Transaction pay(PayDto payDto, String login) {
        Client client = clientService.findByLogin(login);
        return transactionRepository.save(createTransaction(client, payDto.getSum(), payDto.getPhoneNumber()));
    }

    public Transaction createTransaction(Client client, BigDecimal requiredSum, String phoneNumber) {
        // работа с деньгами
        BigDecimal currentSum = client.getBalance();

        if (requiredSum.scale() > 2)
            throw new IllegalArgumentException("Money entered incorrectly");

        if (requiredSum.compareTo(currentSum) > 0)
            throw new IllegalStateException("Not enough money");

        // обновление счета клиента
        BigDecimal newCurrentClientBalance = currentSum.subtract(requiredSum);
        client.setBalance(newCurrentClientBalance);

        clientService.save(client);

        // работа с транзакцией
        return new Transaction(new Date(), phoneNumber, requiredSum, client.getId());
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDto> findPageByLogin(String login, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Transaction> transactions = transactionRepository.findAllByClientId(clientService.findIdByLogin(login), pageable);

        return TransactionMapper.toDtoList(transactions.getContent());
    }
}
