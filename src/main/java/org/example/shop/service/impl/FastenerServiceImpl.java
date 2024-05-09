package org.example.shop.service.impl;

import org.example.shop.model.Fastener;
import org.example.shop.repository.impl.FastenerRepositoryImpl;
import org.example.shop.service.FastenerService;

public class FastenerServiceImpl implements FastenerService {
    private FastenerRepositoryImpl fastenerRepository;

    @Override
    public boolean save(Fastener fastener) {
        return fastenerRepository.save(fastener);
    }

    @Override
    public Fastener findById(Long id) {
        return fastenerRepository.findById(id).get();
    }
}