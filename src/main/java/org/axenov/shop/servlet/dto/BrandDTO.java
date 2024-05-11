package org.axenov.shop.servlet.dto;

import org.axenov.shop.model.Fastener;

import java.util.List;

public class BrandDTO {
    private long idBrand;
    private String nameBrand;
    private List<Fastener> fastenerList;

    public BrandDTO() {
    }

    public BrandDTO(long idBrand, String nameBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
    }

    public BrandDTO(long idBrand, String nameBrand, List<Fastener> fastenerList) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.fastenerList = fastenerList;
    }

    public long getIdBrand(){
        return idBrand;
    }
    public  String getNameBrand(){
        return nameBrand;
    }
    public List<Fastener> getFastenerList() {
        return fastenerList;
    }

    public void setFastenerList(List<Fastener> fastenerList) {
        this.fastenerList = fastenerList;
    }

    public void setIdBrand(long idBrand) {
        this.idBrand = idBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }
}
