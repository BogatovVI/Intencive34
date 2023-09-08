package ru.aston.bogatov_vi.task3.Dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.bogatov_vi.task3.Entity.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    static UserDao userDao;

    @BeforeAll
    static void init(){
        userDao = new UserDao();
    }

    @Test
    void findAll() {
        List<User> userList = userDao.findAll();
        assertEquals(userList.get(0).getName(), "Vlad");
    }

    @Test
    void findEntityById() {
        User user = new User(3, "Oksana", "Bogatova",
                "89999999999", "bo@mail.ru", 4);
        assertEquals(userDao.findEntityById(user.getId()).getSurname(), "Bogatova");
    }

    @Test
    void delete() {
        User user = new User(3, "Oksana", "Bogatova",
                "89999999999", "bo@mail.ru", 4);
        assertTrue(userDao.delete(user.getId()));
    }

    @Test
    void create() {
        User user = new User(3, "Ivan", "Bogatov",
                "89999999999", "bi@mail.ru", 4);
        assertTrue(userDao.create(user));
    }

    @Test
    void update() {
        User user = new User(3, "Oksana", "Bogatova",
                "89999999999", "bo@mail.ru", 4);
        assertEquals(userDao.update(user).getName(), "Oksana");
    }

    @Test
    void joinUsersAndOrders(){
        String output = "Имя пользователя: Vlad Именование заказа: Заказ цветов";
        assertEquals(userDao.joinUsersAndOrders().get(0), output);
    }
}