package ru.erlurdor.TestProject.client;

import ru.erlurdor.TestProject.client.balance.ClientBalanceDto;
import ru.erlurdor.TestProject.client.registration.ClientRegistrationDto;

public interface ClientService {
    Client save(Client client);

    Client save(ClientRegistrationDto clientRegistrationDto);

    Client save(ClientDataDto clientDataDto, String login);

    Client findByLogin(String login);

    ClientBalanceDto findBalance(String login);

    int findIdByLogin(String login);
}
