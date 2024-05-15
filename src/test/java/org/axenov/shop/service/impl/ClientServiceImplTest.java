package org.axenov.shop.service.impl;

import org.axenov.shop.model.Client;
import org.axenov.shop.repository.impl.ClientRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
    @Mock
    private ClientRepositoryImpl clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void testSave() {
        Client client = new Client();
        client.setFirstName("Alex");
        client.setIdUser(1L);
        client.setLastName("Juke");
        client.setEmail("test@mail.com");

        boolean saved = clientService.save(client);

        verify(clientRepository).save(client);

       assertEquals(true, saved);
    }

    @Test
    void testFindById() {
        Client client = new Client();
        client.setFirstName("Alex");
        client.setIdUser(1L);
        client.setLastName("Juke");
        client.setEmail("test@mail.com");


        when(clientRepository.findById(1L)).thenReturn(client);

        Client foundClient = clientRepository.findById(1L);

        verify(clientRepository).findById(1L);

        assertEquals(client, foundClient);
    }
}
