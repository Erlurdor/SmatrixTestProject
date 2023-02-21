package ru.erlurdor.TestProject.client;

import java.math.BigDecimal;

public class ClientTestFactory {
    static public Client createClient() {
        return new Client("123", "some password", BigDecimal.valueOf(1000.00));
    }
}
