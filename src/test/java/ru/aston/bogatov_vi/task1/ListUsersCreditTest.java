package ru.aston.bogatov_vi.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListUsersCreditTest {

    ListUsersCredit listUsersCredit;
    TreeSet<Integer> testTree;
    Map<Integer, User> testMap;
    List<Credit> ParamList;
    List<Credit> ParamList2;

    @BeforeEach
    void initListUsersCredit() {
        User user1 = new User(22, "Конов", "Александр");
        User user2 = new User(44, "Богатов", "Владислав");
        User user3 = new User(55, "Нуриев", "Тамерлан");

        ParamList = new ArrayList<>();
        ParamList2 = new ArrayList<>();
        ParamList.add(new CreditAuto(BigDecimal.valueOf(220000), user1, 1));
        ParamList.add(new CreditConsumer(BigDecimal.valueOf(100000), user2, 2));
        ParamList.add(new CreditAuto(BigDecimal.valueOf(50000), user3, 3));
        ParamList2.add(new CreditAuto(BigDecimal.valueOf(220000), user1, 1));
        ParamList2.add(new CreditConsumer(BigDecimal.valueOf(1000), user1, 2));
        ParamList2.add(new CreditAuto(BigDecimal.valueOf(50000), user3, 3));
        listUsersCredit = new ListUsersCredit(ParamList);

        testTree = new TreeSet<>();
        testTree.add(20);
        testTree.add(1);
        testTree.add(240);
        testTree.add(6);

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
        assertFalse(ParamList.equals(ParamList2));
        assertEquals(testTree.pollLast(), 240);
        ParamList.clear();
    }
}