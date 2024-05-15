package org.axenov.shop.service;

import org.axenov.shop.model.Client;

public interface ClientService {
    boolean save (Client client);

    Client findById(Long id);
}
