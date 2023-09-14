package ru.aston.bogatov_vi.task3.Repository;

import ru.aston.bogatov_vi.task3.Dao.OrderDao;
import ru.aston.bogatov_vi.task3.Entity.Order;

import java.util.List;

public class OrderRepository {
    private final OrderDao orderDao;

    public OrderRepository(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> findAll(){
        return orderDao.findAll();
    }

    public Order findEntityById(int id){
        return orderDao.findEntityById(id);
    }

    public boolean delete(int id){
        return orderDao.delete(id);
    }

    public boolean create(Order order) {
        return orderDao.create(order);
    }

    public Order update(Order order) {
        return orderDao.update(order);
    }
}