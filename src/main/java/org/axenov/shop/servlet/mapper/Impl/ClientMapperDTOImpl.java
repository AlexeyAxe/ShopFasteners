package org.axenov.shop.servlet.mapper.Impl;

import org.axenov.shop.model.Client;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.servlet.mapper.ClientMapperDTO;

public class ClientMapperDTOImpl implements ClientMapperDTO {
    @Override
    public ClientDTO toClientDTO(Client client) {
        ClientDTO clientDTO =new ClientDTO();
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setIdUser(client.getIdUser());
        return clientDTO;
    }

    @Override
    public Client toClient(ClientDTO clientDTO) {
        Client client =new Client();
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setIdUser(clientDTO.getIdUser());
        return client;
    }
}
