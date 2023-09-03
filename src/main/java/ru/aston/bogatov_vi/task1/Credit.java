package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;

public abstract class Credit implements Discount {
    protected BigDecimal sumCredit;
    private User user;
    private int id;

    public Credit(BigDecimal sumCredit, User user, int id) {
        BigDecimal sumCreditException = new BigDecimal("0");
        if (sumCredit.compareTo(sumCreditException) <= 0){
            throw new CreditException("Сумма кредита должна быть больше нуля", EnumException.CREATE_CREDIT_EXCEPTION);
        }
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