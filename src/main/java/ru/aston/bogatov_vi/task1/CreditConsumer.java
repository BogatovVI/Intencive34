package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;

public class CreditConsumer extends Credit{

    private final BigDecimal percentConsumer = new BigDecimal("0.1");
    public CreditConsumer(BigDecimal sumCredit, User user, int id) {
        super(sumCredit, user, id);
    }

    @Override
    public BigDecimal getDiscount() {
        return sumCredit.add(percentConsumer);
    }
}
