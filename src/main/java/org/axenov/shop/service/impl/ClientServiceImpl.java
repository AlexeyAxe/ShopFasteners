package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Client;
import org.axenov.shop.repository.impl.ClientRepositoryImpl;
import org.axenov.shop.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private ClientRepositoryImpl clientRepository;
    private final ConnectionManager connectionManager;

    public ClientServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        clientRepository =new ClientRepositoryImpl(connectionManager);
    }

    public ClientServiceImpl(ClientRepositoryImpl clientRepository, ConnectionManager connectionManager) {
        this.connectionManager=connectionManager;
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }
}
