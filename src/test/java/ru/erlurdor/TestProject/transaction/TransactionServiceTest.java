package ru.erlurdor.TestProject.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.erlurdor.TestProject.client.Client;
import ru.erlurdor.TestProject.client.ClientService;
import ru.erlurdor.TestProject.client.ClientTestFactory;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactionServiceTest {
    @Autowired
    TransactionServiceImp transactionServiceImp;

    @MockBean
    ClientService clientService;

    @MockBean
    TransactionRepository transactionRepository;

    @Test
    void successfulCreateTransaction() {
        String phoneNumber = "123";
        Date date = new Date();
        BigDecimal requiredSum = BigDecimal.valueOf(10.00);
        Client client = ClientTestFactory.createClient();
        Transaction expectedTransaction = new Transaction(date, phoneNumber, requiredSum, client.getId());

        when(clientService.findByLogin(client.getLogin())).thenReturn(client);
        when(clientService.save(client)).thenReturn(client);

        Transaction actualTransaction = transactionServiceImp.createTransaction(client, requiredSum, phoneNumber);

        assertEquals(actualTransaction.getClientId(), expectedTransaction.getClientId());
        assertEquals(actualTransaction.getPhoneNumber(), expectedTransaction.getPhoneNumber());
        assertEquals(actualTransaction.getSum(), expectedTransaction.getSum());
    }

    @Test
    void NotEnoughMoneyCreateTransaction() {
        String phoneNumber = "123";
        BigDecimal requiredSum = BigDecimal.valueOf(1000000.00);
        Client client = ClientTestFactory.createClient();

        when(clientService.findByLogin(client.getLogin())).thenReturn(client);
        when(clientService.save(client)).thenReturn(client);

        assertThrows(IllegalStateException.class, () -> {
            transactionServiceImp.createTransaction(client, requiredSum, phoneNumber);
        });
    }

    @Test
    void MoneyEnteredIncorrectlyCreateTransaction() {
        String phoneNumber = "123";
        BigDecimal requiredSum = BigDecimal.valueOf(10.125);
        Client client = ClientTestFactory.createClient();

        when(clientService.findByLogin(client.getLogin())).thenReturn(client);
        when(clientService.save(client)).thenReturn(client);

        assertThrows(IllegalArgumentException.class, () -> {
            transactionServiceImp.createTransaction(client, requiredSum, phoneNumber);
        });
    }

}