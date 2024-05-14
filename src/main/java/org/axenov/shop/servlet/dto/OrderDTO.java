package org.axenov.shop.servlet.dto;

import java.time.LocalDate;

public class OrderDTO {
    private long idOrder;
    private LocalDate dateOrder;
    private String status;
    private long idUser;
    private long idFastener;
    private int quantity;

    public OrderDTO() {
    }

    public OrderDTO(long idOrder, LocalDate dateOrder, String status, long idUser, long idFastener, int quantity) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.status = status;
        this.idUser = idUser;
        this.idFastener = idFastener;
        this.quantity = quantity;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdFastener() {
        return idFastener;
    }

    public void setIdFastener(long idFastener) {
        this.idFastener = idFastener;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

