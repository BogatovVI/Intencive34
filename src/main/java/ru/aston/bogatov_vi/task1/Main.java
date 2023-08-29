package ru.aston.bogatov_vi.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
        User user1 = new User(22, "Конов", "Александр");
        User user2 = new User(44, "Богатов", "Владислав");
        User user3 = new User(55, "Нуриев", "Тамерлан");

        List<Credit> ParamList = new ArrayList<>();
        ParamList.add(new CreditAuto(BigDecimal.valueOf(220000), user1, 1));
        ParamList.add(new CreditConsumer(BigDecimal.valueOf(100000), user2, 2));
        ParamList.add(new CreditAuto(BigDecimal.valueOf(50000), user3, 3));
        ListUsersCredit creditListResult = new ListUsersCredit(ParamList);

        System.out.println(creditListResult.calcCreditAmount());

        ParamList = creditListResult.outSortList();
        for (Credit credit : ParamList){
            System.out.println(credit.getUser().getSourName());
        }
    }
}