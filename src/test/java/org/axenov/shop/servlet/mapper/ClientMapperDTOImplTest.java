package org.axenov.shop.servlet.mapper;

import org.axenov.shop.model.Client;
import org.axenov.shop.servlet.dto.ClientDTO;
import org.axenov.shop.servlet.mapper.Impl.ClientMapperDTOImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientMapperDTOImplTest {

    @Test
    void testToClientDTO() {
        Client client = new Client(1L, "Andry","Skarinkin", "andry@rw.by",null);
        ClientMapperDTO clientMapperDTO=new ClientMapperDTOImpl();
        ClientDTO clientDTO = clientMapperDTO.toClientDTO(client);

        assertEquals(client.getIdUser(), clientDTO.getIdUser());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getEmail(), clientDTO.getEmail());
        assertEquals(client.getOrderList(), clientDTO.getOrderList());
    }

    @Test
    void testToClient() {
        ClientDTO clientDTO = new ClientDTO(1L, "Andry","Skarinkin", "andry@rw.by",null);

        ClientMapperDTO clientMapperDTO=new ClientMapperDTOImpl();
        Client client = clientMapperDTO.toClient(clientDTO);
        assertEquals(client.getIdUser(), clientDTO.getIdUser());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getEmail(), clientDTO.getEmail());
        assertEquals(client.getOrderList(), clientDTO.getOrderList());
    }
}