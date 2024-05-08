package org.example.shop.model;


import java.sql.Date;
import java.util.Objects;

public class Order {
    private long idOrder;
    private Date dateOrder;
    private String status;
    private long idUser;
    private User user;

    public Order(long idOrder, Date dateOrder, String status, long idUser, User user) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.status = status;
        this.idUser = idUser;
        this.user = user;
    }

    public Order() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public java.sql.Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder && idUser == order.idUser && Objects.equals(dateOrder, order.dateOrder) && Objects.equals(status, order.status) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, dateOrder, status, idUser, user);
    }

    @Override
    public String toString() {
        return "order{" +
                "idOrder=" + idOrder +
                ", dateOrder=" + dateOrder +
                ", status='" + status + '\'' +
                ", idUser=" + idUser +
                ", user=" + user +
                '}';
    }
}
