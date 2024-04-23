package org.example.shop.servlet.dto;

public class UserDTO {
    private long idUser;
    private String firstName;
    private String lastNamed;
    private String email;

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

    public String getLastNamed() {
        return lastNamed;
    }

    public void setLastNamed(String lastNamed) {
        this.lastNamed = lastNamed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
