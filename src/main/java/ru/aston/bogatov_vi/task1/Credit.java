package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;

public abstract class Credit implements Discount{
    BigDecimal sumCredit;
    User user;
    int id;

    public Credit(BigDecimal sumCredit, User user, int id) {
        this.sumCredit = sumCredit;
        this.user = user;
        this.id = id;
    }

    public BigDecimal getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(BigDecimal sumCredit) {
        this.sumCredit = sumCredit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}