package org.axenov.shop.servlet.mapper.Impl;

import org.axenov.shop.model.Brand;
import org.axenov.shop.servlet.dto.BrandDTO;
import org.axenov.shop.servlet.mapper.BrandMapperDTO;

public class BrandMapperDTOImpl implements BrandMapperDTO{

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        BrandDTO brandDTO=new BrandDTO();
        brandDTO.setIdBrand(brand.getIdBrand());
        brandDTO.setNameBrand(brand.getNameBrand());
        return brandDTO;
    }

    @Override
    public Brand toBrand(BrandDTO brandDTO) {
        Brand brand=new Brand();
        brand.setIdBrand(brandDTO.getIdBrand());
        brand.setNameBrand(brandDTO.getNameBrand());
        return brand;
    }
}
