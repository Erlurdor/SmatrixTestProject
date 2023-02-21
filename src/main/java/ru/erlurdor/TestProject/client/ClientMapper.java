package ru.erlurdor.TestProject.client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    static public ClientDto toDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getLogin(),
                client.getPassword(),
                client.getBalance(),
                client.getFio(),
                client.getEmail(),
                client.getGender(),
                client.getBirthday()
        );
    }

    static public List<ClientDto> toDtoList(List<Client> clients) {
        return clients.stream().map(ClientMapper::toDto).collect(Collectors.toList());
    }
}
