package org.example.shop.model;

import java.util.List;
import java.util.Objects;

public class Brand {
    private long idBrand;
    private String nameBrand;
    private List<Fastener> fastenerList;

    public Brand() {
    }

    public Brand(long idBrand, String nameBrand, List<Fastener> fastenerList) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.fastenerList = fastenerList;
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

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return idBrand == brand.idBrand && Objects.equals(nameBrand, brand.nameBrand) &&
                Objects.equals(fastenerList, brand.fastenerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBrand, nameBrand, fastenerList);
    }

    @Override
    public String toString() {
        return "brand{" +
                "idBrand=" + idBrand +
                ", nameBrand='" + nameBrand + '\'' +
                ", fastenerList=" + fastenerList +
                '}';
    }
}
