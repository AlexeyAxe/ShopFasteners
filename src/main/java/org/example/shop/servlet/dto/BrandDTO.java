package org.example.shop.servlet.dto;

public class BrandDTO {
    private long idBrand;
    private String brandName;

    public BrandDTO(long idBrand, String brandName) {
        this.idBrand = idBrand;
        this.brandName = brandName;
    }

    public long getIdBrand(){
        return idBrand;
    }
    public  String getBrandName(){
        return brandName;
    }

    public void setIdBrand(long idBrand) {
        this.idBrand = idBrand;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
