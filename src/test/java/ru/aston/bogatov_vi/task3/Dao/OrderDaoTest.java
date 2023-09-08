package ru.aston.bogatov_vi.task3.Dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.bogatov_vi.task3.Entity.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {

    static OrderDao orderDao;

    @BeforeAll
    static void init(){
        orderDao = new OrderDao();
    }

    @Test
    void findAll() {
        List<Order> orderList = orderDao.findAll();
        assertEquals(orderList.get(2).getNameOrder(), "Заказ сладкого");
    }

    @Test
    void findEntityById() {
        Order order = new Order(4, "Заказ сладкого");
        assertEquals(orderDao.findEntityById(order.getId()).getNameOrder(), "Заказ сладкого");
    }

    @Test
    void delete() {
        assertTrue(orderDao.delete(3));
    }

    @Test
    void create() {
        Order order = new Order(1, "Заказ цветов");
        assertTrue(orderDao.create(order));
    }

    @Test
    void update() {
        Order order = new Order(4, "Заказ сладкого");
        assertEquals(orderDao.update(order).getNameOrder(), "Заказ сладкого");
    }
}