package ru.aston.bogatov_vi.task5.my;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.bogatov_vi.task5.Entity.Birthday;
import ru.aston.bogatov_vi.task5.Entity.Order;
import ru.aston.bogatov_vi.task5.Entity.OrderFace;
import ru.aston.bogatov_vi.task5.Entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HibernateTest {

    private static SessionFactory sessionFactory;
    private Session session;


    @BeforeAll
    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    public void start() {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void stop() {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test1() {

        User user = User
                .builder()
                .email("vl@mail.ru")
                .birthday(new Birthday(LocalDate.of(1999, 9, 13)))
                .surname("Богатов")
                .name("Владислав")
                .telephone("+7999999999")
                .build();

        Order order = Order.builder()
                .name("Order_" + RandomString.make(4))
                .orderFace(OrderFace.LEGAL)
                .user(user)
                .build();

        session.saveOrUpdate(order);
    }

}
