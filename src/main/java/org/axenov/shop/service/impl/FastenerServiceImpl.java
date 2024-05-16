package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.model.Fastener;
import org.axenov.shop.repository.impl.FastenerRepositoryImpl;
import org.axenov.shop.service.FastenerService;

public class FastenerServiceImpl implements FastenerService {
    private final FastenerRepositoryImpl fastenerRepository;
    private final ConnectionManagerImpl connectionManager;

    public FastenerServiceImpl(FastenerRepositoryImpl fastenerRepository, ConnectionManagerImpl connectionManager) {
        this.connectionManager=connectionManager;
        this.fastenerRepository = fastenerRepository;
    }

    @Override
    public boolean save(Fastener fastener) {
        return fastenerRepository.save(fastener);
    }

    @Override
    public Fastener findById(Long id) {
        return fastenerRepository.findById(id);
    }
}