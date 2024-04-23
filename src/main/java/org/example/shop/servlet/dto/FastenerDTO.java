package org.example.shop.servlet.dto;

import java.math.BigDecimal;

public class FastenerDTO {
    private long idFastener;
    private String name;
    private BigDecimal price;

    public long getIdFastener(){
        return idFastener;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setIdFastener(long idFastener){
     this.idFastener=idFastener;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(BigDecimal price){
        this.price=price;
    }
}
