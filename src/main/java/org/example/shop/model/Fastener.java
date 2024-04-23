package org.example.shop.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Fastener {
    private long idFastener;
    private String name;
    private BigDecimal price;
    private List <Brand> brandList;

    public Fastener(long idFastener, String name, BigDecimal price, List<Brand> brandList) {
        this.idFastener = idFastener;
        this.name = name;
        this.price = price;
        this.brandList = brandList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public long getIdFastener() {
        return idFastener;
    }

    public void setIdFastener(long idFastener) {
        this.idFastener = idFastener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fastener)) return false;
        Fastener fastener = (Fastener) o;
        return idFastener == fastener.idFastener && Objects.equals(name, fastener.name) && Objects.equals(price, fastener.price) && Objects.equals(brandList, fastener.brandList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFastener, name, price, brandList);
    }

    @Override
    public String toString() {
        return "Fastener{" +
                "idFastener=" + idFastener +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brandList=" + brandList +
                '}';
    }
}
