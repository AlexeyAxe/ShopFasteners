package org.axenov.shop.servlet.dto;

import org.axenov.shop.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class FastenerDTO {
    private long idFastener;
    private String nameFastener;
    private List<Brand> brandList;

    public FastenerDTO(long idFastener, String nameFastener) {
        this.idFastener = idFastener;
        this.nameFastener = nameFastener;
        brandList=new ArrayList<>();
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
