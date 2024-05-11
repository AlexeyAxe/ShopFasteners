package org.axenov.shop.service;

import org.axenov.shop.model.Brand;

public interface BrandService {
    boolean save (Brand brand);

   Brand findById(Long id);
}
