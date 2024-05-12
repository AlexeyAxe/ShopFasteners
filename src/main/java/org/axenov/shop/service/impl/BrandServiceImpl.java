package org.axenov.shop.service.impl;

import org.axenov.shop.db.ConnectionManager;
import org.axenov.shop.db.ConnectionManagerImpl;
import org.axenov.shop.service.BrandService;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

public class BrandServiceImpl implements BrandService {
    private final BrandRepositoryImpl brandRepository;
    private final ConnectionManager connectionManager;


    public BrandServiceImpl(BrandRepositoryImpl brandRepository, ConnectionManager connectionManager) {
        this.connectionManager=connectionManager;
        this.brandRepository = brandRepository;

    }

    public BrandServiceImpl()  {
        connectionManager= new ConnectionManagerImpl();
        brandRepository=new BrandRepositoryImpl(connectionManager.getConnection());
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
