package ru.aston.bogatov_vi.task3.Entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private String telephone;
    private String mail;
    private int orderId;

    public User(int id, String name, String surname, String telephone, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.mail = mail;
    }

    public User(int id, String name, String surname, String telephone, String mail, int orderId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.mail = mail;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}