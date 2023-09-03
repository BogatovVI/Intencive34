package ru.aston.bogatov_vi.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListUsersCreditTest {

    private ListUsersCredit listUsersCredit;
    private TreeSet<Integer> testTree;
    private Map<Integer, User> testMap;
    private List<Credit> paramList;

    private List<Credit> paramList2;

    @BeforeEach
    void initListUsersCredit() {
        User user1 = new User(22, "Конов", "Александр");
        User user2 = new User(44, "Богатов", "Владислав");
        User user3 = new User(55, "Нуриев", "Тамерлан");

        paramList = new ArrayList<>();
        paramList2 = new ArrayList<>();
        paramList.add(new CreditAuto(new BigDecimal("220000"), user1, 1));
        paramList.add(new CreditConsumer(new BigDecimal("100000"), user2, 2));
        paramList.add(new CreditAuto(new BigDecimal("50000"), user3, 3));
        paramList2.add(new CreditAuto(new BigDecimal("220000"), user1, 1));
        paramList2.add(new CreditConsumer(new BigDecimal("1000"), user1, 2));
        paramList2.add(new CreditAuto(new BigDecimal("50000"), user3, 3));
        listUsersCredit = new ListUsersCredit(paramList);

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
        assertEquals(new BigDecimal("370000"), listUsersCredit.calcCreditAmount());
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
            Credit credit = new CreditAuto(new BigDecimal("0"), userTest, 55);
        });
    }

    @Test
    void testUserCreateException() {
        assertThrows(CreditException.class, () -> {
            User userTest = new User(0, "Ахметов", "");
        });
    }

    @Test
    void testStruct(){
        assertFalse(paramList.equals(paramList2));
        assertEquals(testTree.pollLast(), 240);
        paramList.clear();
    }
}