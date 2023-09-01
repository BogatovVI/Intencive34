package ru.aston.bogatov_vi.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListUsersCreditTest {

    ListUsersCredit listUsersCredit;
    TreeSet<Credit> testTree;
    Map<Integer, User> testMap;
    List<Credit> ParamList;

    @BeforeEach
    void initListUsersCredit() {
        User user1 = new User(22, "Конов", "Александр");
        User user2 = new User(44, "Богатов", "Владислав");
        User user3 = new User(55, "Нуриев", "Тамерлан");

        ParamList = new ArrayList<>();
        ParamList.add(new CreditAuto(BigDecimal.valueOf(220000), user1, 1));
        ParamList.add(new CreditConsumer(BigDecimal.valueOf(100000), user2, 2));
        ParamList.add(new CreditAuto(BigDecimal.valueOf(50000), user3, 3));
        listUsersCredit = new ListUsersCredit(ParamList);

        //testTree = new TreeSet<>(ParamList);
        testMap = new HashMap<>();

        testMap.put(1, user1);
        testMap.put(2, user2);
        testMap.put(3, user3);
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

    @Test
    void testCreditException() {
        assertThrows(CreditException.class, () -> {
            User userTest = new User(50, "Ахметов", "Руслан");
            Credit credit = new CreditAuto(BigDecimal.valueOf(0), userTest, 55);
        });
    }

    @Test
    void testStruct(){
        ParamList.clear();
    }
}