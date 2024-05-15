package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Client;
import org.axenov.shop.servlet.dto.ClientDTO;

public interface ClientMapperDTO {

    ClientDTO toClientDTO(Client client);

   Client toClient(ClientDTO clientDTO);

}
