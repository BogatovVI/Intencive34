package ru.aston.bogatov_vi.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUsersCreditTest {

    ListUsersCredit listUsersCredit;

    @BeforeEach
    void initListUsersCredit(){
        User user1 = new User(22, "Конов", "Александр");
        User user2 = new User(44, "Богатов", "Владислав");
        User user3 = new User(55, "Нуриев", "Тамерлан");

        List<Credit> ParamList = new ArrayList<>();
        ParamList.add(new CreditAuto(BigDecimal.valueOf(220000), user1, 1));
        ParamList.add(new CreditConsumer(BigDecimal.valueOf(100000), user2, 2));
        ParamList.add(new CreditAuto(BigDecimal.valueOf(50000), user3, 3));
        listUsersCredit = new ListUsersCredit(ParamList);
    }

    @Test
    void calcCreditAmount() {
        assertEquals(BigDecimal.valueOf(370000), listUsersCredit.calcCreditAmount());
    }

    @Test
    void outSortList() {
        assertEquals(listUsersCredit.outSortList().get(0).getUser().getSourName(), "Богатов");
        assertEquals(listUsersCredit.outSortList().get(2).getUser().getSourName(), "Нуриев");
    }
}