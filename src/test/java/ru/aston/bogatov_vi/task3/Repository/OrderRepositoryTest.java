package ru.aston.bogatov_vi.task3.Repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.bogatov_vi.task3.Dao.OrderDao;
import ru.aston.bogatov_vi.task3.Entity.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderRepositoryTest {

    @Mock
    OrderDao orderDao;

    @InjectMocks
    OrderRepository orderRepository;

    @Test
    void findAll() {
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order(1, "Заказ цветов");
        Order order2 = new Order(2, "Заказ сладкого");
        orderList.add(order1);
        orderList.add(order2);
        Mockito.when(orderDao.findAll()).thenReturn(orderList);
        assertEquals(orderRepository.findAll().get(1).getNameOrder(), "Заказ сладкого");
    }

    @Test
    void findEntityById() {
        Order order = new Order(4, "Заказ сладкого");
        Mockito.when(orderDao.findEntityById(order.getId())).thenReturn(order);
        Order actual = orderRepository.findEntityById(order.getId());
        assertEquals(actual.getNameOrder(), "Заказ сладкого");
    }

    @Test
    void delete() {
        Mockito.when(orderDao.delete(4)).thenReturn(true);
        assertTrue(orderRepository.delete(4));
    }

    @Test
    void create() {
        Order order = new Order(5, "Заказ цветов");
        Mockito.when(orderDao.create(order)).thenReturn(true);
        assertTrue(orderRepository.create(order));
    }

    @Test
    void update() {
        Order orderOld = new Order(5, "Заказ цветов");
        Order orderNew = new Order(5, "Заказ сладкого");
        Mockito.when(orderDao.update(orderOld)).thenReturn(orderNew);
        assertEquals(orderRepository.update(orderOld).getNameOrder(), orderNew.getNameOrder());
    }
}