package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;
import java.util.List;

public class ListUsersCredit implements CreditCalculation {
    private final List<Credit> creditList;

    public ListUsersCredit(List<Credit> creditList) {
        this.creditList = creditList;
    }

    //Подсчет суммы кредитов
    @Override
    public BigDecimal calcCreditAmount() {
        BigDecimal CreditAmount = new BigDecimal("0");

        for(Credit credit : creditList){
            CreditAmount = CreditAmount.add(credit.getSumCredit());
        }
        return CreditAmount;
    }

    //Вывод списка кредитов в отсортированном виде
    public List<Credit> outSortList() {
        CreditComparator creditComparator = new CreditComparator();
        creditList.sort(creditComparator);
        return creditList;
    }
}