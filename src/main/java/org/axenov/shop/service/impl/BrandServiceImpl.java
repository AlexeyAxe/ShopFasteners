package org.axenov.shop.service.impl;

import org.axenov.shop.service.BrandService;
import org.axenov.shop.model.Brand;
import org.axenov.shop.repository.impl.BrandRepositoryImpl;

public class BrandServiceImpl implements BrandService {
    private BrandRepositoryImpl brandRepository;

    public BrandServiceImpl(BrandRepositoryImpl brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandServiceImpl() {
    }

    @Override
    public boolean save(Brand brand) {
        return brandRepository.save(brand);
           }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }
}
