package org.example.shop.service.impl;

import org.example.shop.model.Brand;
import org.example.shop.repository.impl.BrandRepositoryImpl;
import org.example.shop.service.BrandService;

public class BrandServiceImpl implements BrandService {
    private BrandRepositoryImpl brandRepository;

    @Override
    public boolean save(Brand brand) {
        return brandRepository.save(brand);
           }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }
}
