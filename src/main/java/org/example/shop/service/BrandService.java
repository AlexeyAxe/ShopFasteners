package org.example.shop.service;

import org.example.shop.model.Brand;

import java.util.UUID;

public interface BrandService {
    boolean save (Brand brand);

   Brand findById(Long id);
}
