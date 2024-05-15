package org.axenov.shop.service.impl;

import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.impl.FastenerRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class FastenerServiceImplTest {
    @Mock
    private FastenerRepositoryImpl fastenerRepository;

    @InjectMocks
    private FastenerServiceImpl fastenerService;

    @Test
    void testSave() {
        Fastener fastener = new Fastener();
        fastener.setNameFastener("Test Fastener");

        boolean saved = fastenerService.save(fastener);

        verify(fastenerRepository).save(fastener);

        assertTrue(saved);
    }

    @Test
    void testFindById() {
        Fastener fastener = new Fastener();
        fastener.setNameFastener("Test Fastener");
        fastener.setIdFastener(1L);

        when(fastenerRepository.findById(1L)).thenReturn(fastener);

        Fastener foundFastener = fastenerService.findById(1L);

        verify(fastenerRepository).findById(1L);

        assertEquals(fastener, foundFastener);
    }

}
