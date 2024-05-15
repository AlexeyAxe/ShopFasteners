package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.service.BrandService;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;


public class BrandServiceImpl implements BrandService {
    private final BrandRepositoryImpl brandRepository;
    private final ConnectionManagerImpl connectionManager;


    public BrandServiceImpl(BrandRepositoryImpl brandRepository, ConnectionManagerImpl connectionManager) {
        this.connectionManager=connectionManager;
        this.brandRepository = brandRepository;

    }

    public BrandServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        brandRepository=new BrandRepositoryImpl(connectionManager);
    }

    @Override
    public boolean save(Brand brand) {
        return brandRepository.save(brand);
           }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id);
    }
}
