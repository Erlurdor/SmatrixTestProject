package ru.erlurdor.TestProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.erlurdor.TestProject.client.Client;
import ru.erlurdor.TestProject.client.ClientService;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientService clientService;

    @Autowired
    public CustomUserDetailsService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientService.findByLogin(login);

        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(
                client.getLogin(),
                client.getPassword(),
                Collections.emptyList()
        );
    }
}
