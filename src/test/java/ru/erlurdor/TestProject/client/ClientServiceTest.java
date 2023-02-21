package ru.erlurdor.TestProject.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.erlurdor.TestProject.client.balance.ClientBalanceDto;
import ru.erlurdor.TestProject.client.registration.ClientRegistrationDto;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    ClientServiceImp clientServiceImp;

    @MockBean
    ClientRepository clientRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    void createClient() {
        Client expectedClient = ClientTestFactory.createClient();
        ClientRegistrationDto clientRegistrationDto = new ClientRegistrationDto(expectedClient.getLogin(), expectedClient.getPassword());
        String encodedPassword = "encodedPassword";

        when(passwordEncoder.encode(expectedClient.getPassword())).thenReturn(encodedPassword);

        Client actualClient = clientServiceImp.createClient(clientRegistrationDto);

        assertEquals(expectedClient.getLogin(), actualClient.getLogin());
        assertEquals(encodedPassword, actualClient.getPassword());
    }

    @Test
    void userAlreadyExistSave() {
        Client client = ClientTestFactory.createClient();
        ClientRegistrationDto clientRegistrationDto = new ClientRegistrationDto(client.getLogin(), client.getPassword());

        when(clientRepository.findByLogin(client.getLogin())).thenReturn(client);

        assertThrows(IllegalArgumentException.class, () -> {
            clientServiceImp.save(clientRegistrationDto);
        });
    }

    @Test
    void saveSuccess() {
        Client expectedClient = ClientTestFactory.createClient();
        ClientRegistrationDto clientRegistrationDto = new ClientRegistrationDto(expectedClient.getLogin(), expectedClient.getPassword());

        when(clientRepository.findByLogin(expectedClient.getLogin())).thenReturn(null);
        when(clientRepository.save(expectedClient)).thenReturn(expectedClient);

        clientServiceImp.save(clientRegistrationDto);
    }

    @Test
    void findBalance() {
        Client client = ClientTestFactory.createClient();
        ClientBalanceDto expectedClientBalanceDto = new ClientBalanceDto(client.getLogin(), client.getBalance());

        when(clientRepository.findByLogin(client.getLogin())).thenReturn(client);

        ClientBalanceDto actualClientBalanceDto = clientServiceImp.findBalance(client.getLogin());

        assertEquals(expectedClientBalanceDto.getBalance(), actualClientBalanceDto.getBalance());
        assertEquals(expectedClientBalanceDto.getClientLogin(), actualClientBalanceDto.getClientLogin());
    }
}