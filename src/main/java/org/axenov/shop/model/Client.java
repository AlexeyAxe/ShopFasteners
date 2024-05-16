package org.axenov.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Client {
    private long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orderList;

    public Client(long idUser, String firstName, String lastName, String email, List<Order> orderList) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orderList = orderList;
    }

    public Client(long idUser, String firstName, String lastName, String email) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        orderList=new ArrayList<>();
    }

    public Client() {

    }

    public List<Order> getOrderList() {
        return orderList;
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

    public void setLastName(String lastNamed) {
        this.lastName = lastNamed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }

        Client client = (Client) o;
        return idUser == client.idUser && Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, firstName, lastName, email);
    }

}
