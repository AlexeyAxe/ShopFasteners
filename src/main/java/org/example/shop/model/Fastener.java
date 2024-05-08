package org.example.shop.model;

import java.util.List;
import java.util.Objects;

public class Fastener {
    private long idFastener;
    private String name;
    private List <Brand> brandList;

    public Fastener(long idFastener, String name, List<Brand> brandList) {
        this.idFastener = idFastener;
        this.name = name;
        this.brandList = brandList;
    }

    public Fastener() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fastener)) return false;
        Fastener fastener = (Fastener) o;
        return idFastener == fastener.idFastener && Objects.equals(name, fastener.name)
                &&  Objects.equals(brandList, fastener.brandList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFastener, name, brandList);
    }

    @Override
    public String toString() {
        return "fastener{" +
                "idFastener=" + idFastener +
                ", name_fastener='" + name + '\'' +
                ", brandList=" + brandList +
                '}';
    }
}
