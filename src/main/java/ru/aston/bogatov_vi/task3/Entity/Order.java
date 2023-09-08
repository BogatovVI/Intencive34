package ru.aston.bogatov_vi.task3.Entity;

public class Order {
    private int id;
    private String nameOrder;

    public Order(int id, String nameOrder) {
        this.id = id;
        this.nameOrder = nameOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }
}