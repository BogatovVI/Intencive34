package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;

public class CreditConsumer extends Credit{
    public CreditConsumer(BigDecimal sumCredit, User user, int id) {
        super(sumCredit, user, id);
    }

    @Override
    public BigDecimal getDiscount() {
        return sumCredit.add(BigDecimal.valueOf(0.1));
    }
}
