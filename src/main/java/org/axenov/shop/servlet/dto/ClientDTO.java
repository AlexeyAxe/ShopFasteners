package org.axenov.shop.servlet.dto;

import org.axenov.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {
    private long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orderList;

    public ClientDTO() {
    }

    public ClientDTO(long idUser, String firstName, String lastName, String email, List<Order> orderList) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orderList = orderList;
    }

    public ClientDTO(long idUser, String firstName, String lastName, String email) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        orderList=new ArrayList<>();
    }

    public List<Order> getOrderList() {return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
