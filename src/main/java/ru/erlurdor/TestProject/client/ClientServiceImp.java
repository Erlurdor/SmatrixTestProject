package ru.erlurdor.TestProject.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.erlurdor.TestProject.client.balance.ClientBalanceDto;
import ru.erlurdor.TestProject.client.registration.ClientRegistrationDto;

import java.math.BigDecimal;

@Service
public class ClientServiceImp implements ClientService {
    private final ClientRepository clientRepository;
    private final BigDecimal BALANCE = BigDecimal.valueOf(1000);
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImp(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public ClientBalanceDto findBalance(String login) {
        Client client = clientRepository.findByLogin(login);
        return new ClientBalanceDto(client.getLogin(), client.getBalance());
    }

    @Override
    public Client save(ClientDataDto clientDataDto, String login) {
        Client client = clientRepository.findByLogin(login);

        if (clientDataDto.getFio() != null) {
            client.setFio(clientDataDto.getFio());
        }

        if (clientDataDto.getEmail() != null) {
            client.setEmail(clientDataDto.getEmail());
        }

        if (clientDataDto.getGender() != null) {
            client.setGender(clientDataDto.getGender());
        }

        if (clientDataDto.getBirthday() != null) {
            client.setBirthday(clientDataDto.getBirthday());
        }

        return clientRepository.save(client);
    }

    @Override
    public Client save(ClientRegistrationDto clientRegistrationDto) {
        Client client = clientRepository.findByLogin(clientRegistrationDto.getPhoneNumber());
        if (client != null) {
            throw new IllegalArgumentException("User with this login already exist");
        }

        return clientRepository.save(createClient(clientRegistrationDto));
    }

    public Client createClient(ClientRegistrationDto clientRegistrationDto) {
        return new Client(
                clientRegistrationDto.getPhoneNumber(),
                passwordEncoder.encode(clientRegistrationDto.getPassword()),
                BALANCE
        );
    }

    @Override
    public int findIdByLogin(String login) {
        return clientRepository.findByLogin(login).getId();
    }
}
