package org.axenov.shop.model;

import java.util.List;
import java.util.Objects;

public class Fastener {
    private long idFastener;
    private String nameFastener;
    private List <Brand> brandList;

    public Fastener(long idFastener, String nameFastener, List<Brand> brandList) {
        this.idFastener = idFastener;
        this.nameFastener = nameFastener;
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

    public String getNameFastener() {
        return nameFastener;
    }

    public void setNameFastener(String nameFastener) {
        this.nameFastener = nameFastener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fastener)) return false;
        Fastener fastener = (Fastener) o;
        return idFastener == fastener.idFastener && Objects.equals(nameFastener, fastener.nameFastener)
                &&  Objects.equals(brandList, fastener.brandList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFastener, nameFastener, brandList);
    }

    @Override
    public String toString() {
        return "fastener{" +
                "idFastener=" + idFastener +
                ", name_fastener='" + nameFastener + '\'' +
                ", brandList=" + brandList +
                '}';
    }
}
