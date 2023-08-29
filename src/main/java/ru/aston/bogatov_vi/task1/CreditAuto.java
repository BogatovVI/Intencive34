package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;

public class CreditAuto extends Credit{
    private final BigDecimal percentAuto = new BigDecimal("0.05");
    public CreditAuto(BigDecimal sumCredit, User user, int id) {
        super(sumCredit, user, id);
    }

    @Override
    public BigDecimal getDiscount() {
        return sumCredit.add(percentAuto);
    }
}
