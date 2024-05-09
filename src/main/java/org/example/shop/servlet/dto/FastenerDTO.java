package org.example.shop.servlet.dto;

import org.example.shop.model.Brand;

import java.math.BigDecimal;
import java.util.List;

public class FastenerDTO {
    private long idFastener;
    private String nameFastener;
    private List<Brand> brandList;

    public FastenerDTO(long idFastener, String nameFastener) {
        this.idFastener = idFastener;
        this.nameFastener = nameFastener;
    }

    public FastenerDTO(long idFastener, String nameFastener, List<Brand> brandList) {
        this.idFastener = idFastener;
        this.nameFastener = nameFastener;
        this.brandList = brandList;
    }

    public long getIdFastener(){
        return idFastener;
    }
    public String getNameFastener(){
        return nameFastener;
    }
    public void setIdFastener(long idFastener){
     this.idFastener=idFastener;
    }
    public void setNameFastener(String nameFastener){
        this.nameFastener = nameFastener;
    }
    public List<Brand> getBrandList() {
        return brandList;
    }
    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

}
