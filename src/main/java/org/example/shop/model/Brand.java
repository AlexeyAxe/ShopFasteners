package org.example.shop.model;

import java.util.List;
import java.util.Objects;

public class Brand {
    private long idBrand;
    private String brandName;
    private List<Fastener>fastenerList;

    public Brand() {
    }

    public Brand(long idBrand, String brandName, List<Fastener> fastenerList) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.fastenerList = fastenerList;
    }
    public Brand(long idBrand, String brandName) {
        this.idBrand = idBrand;
        this.brandName = brandName;
    }

    public List<Fastener> getFastenerList() {
        return fastenerList;
    }

    public void setFastenerList(List<Fastener> fastenerList) {
        this.fastenerList = fastenerList;
    }

    public long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(long idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return idBrand == brand.idBrand && Objects.equals(brandName, brand.brandName) && Objects.equals(fastenerList, brand.fastenerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBrand, brandName, fastenerList);
    }

    @Override
    public String toString() {
        return "brand{" +
                "idBrand=" + idBrand +
                ", brandName='" + brandName + '\'' +
                ", fastenerList=" + fastenerList +
                '}';
    }
}
