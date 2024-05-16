package org.axenov.shop.model;


import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private long idOrder;
    private LocalDate dateOrder;
    private String status;
    private long idUser;
    private long idFastener;
    private int quantity;

    public Order(long idOrder, LocalDate dateOrder, String status, long idUser, long idFastener, int quantity) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.status = status;
        this.idUser = idUser;
        this.idFastener=idFastener;
        this.quantity =quantity;
    }

    public Order() {

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
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return idOrder == order.idOrder && idUser == order.idUser &&
                Objects.equals(dateOrder, order.dateOrder) &&
                Objects.equals(status, order.status) &&
                Objects.equals(idFastener, order.idFastener) &&
                Objects.equals(quantity, order.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, dateOrder, status, idUser, idFastener, quantity);
    }

}
