package ru.aston.bogatov_vi.task3.Repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.bogatov_vi.task3.Dao.UserDao;
import ru.aston.bogatov_vi.task3.Entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserRepository userRepository;

    @Test
    void findAll() {
        List<User> usersList = new ArrayList<>();
        User user1 = new User(1, "Oksana", "Bogatova",
                "89999999999", "bo@mail.ru", 3);
        User user2 = new User(2, "Ivan", "Bogatov",
                "89999999999", "bi@mail.ru", 4);
        usersList.add(user1);
        usersList.add(user2);
        Mockito.when(userDao.findAll()).thenReturn(usersList);
        assertEquals(userRepository.findAll().get(0).getSurname(), "Bogatova");
    }

    @Test
    void findEntityById() {
        User user = new User(1, "Oksana", "Bogatova",
                "89999999999", "bo@mail.ru", 3);
        Mockito.when(userDao.findEntityById(user.getId())).thenReturn(user);
        assertEquals(userRepository.findEntityById(user.getId()).getId(), user.getId());
    }

    @Test
    void delete() {
        Mockito.when(userDao.delete(1)).thenReturn(true);
        assertTrue(userRepository.delete(1));
    }

    @Test
    void create() {
        User user = new User(2, "Ivan", "Bogatov",
                "89999999999", "bi@mail.ru", 4);
        Mockito.when(userDao.create(user)).thenReturn(true);
        assertTrue(userRepository.create(user));
    }

    @Test
    void update() {
        User userOld = new User(2, "Ivan", "Bogatov",
                "89999999999", "bi@mail.ru", 4);
        User userNew = new User(2, "Vlad", "Bogatov",
                "89999999998", "bv@mail.ru", 4);
        Mockito.when(userDao.update(userOld)).thenReturn(userNew);
        assertEquals(userRepository.update(userOld).getMail(), userNew.getMail());
    }

    @Test
    void joinUsersAndOrders() {
        List<String> listJoin = new ArrayList<>();
        listJoin.add("Имя пользователя: " + "Vlad"
                + " Именование заказа: " + "Заказ цветов");
        listJoin.add("Имя пользователя: " + "Oksana"
                + " Именование заказа: " + "Заказ сладкого");
        Mockito.when(userDao.joinUsersAndOrders()).thenReturn(listJoin);
        assertEquals(userRepository.joinUsersAndOrders().get(0), listJoin.get(0));
    }
}