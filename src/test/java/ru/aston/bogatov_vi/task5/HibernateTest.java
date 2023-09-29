package ru.aston.bogatov_vi.task5;

import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.hibernate.cfg.Configuration;
import ru.aston.bogatov_vi.task5.Entity.*;
import ru.aston.bogatov_vi.task5.Entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class HibernateTest {
    private static SessionFactory sessionFactory;
    private Session session;
    private User user;

    private Order order;

    private UserOrder userOrder;

    @BeforeAll
    public static void init(){
        try{
            Configuration configuration = new Configuration();
            sessionFactory = configuration
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserOrder.class)
                    .buildSessionFactory();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @BeforeEach
    public void start(){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Order> orderList = Stream.generate(
                    () -> Order
                            .builder()
                            .name("Order_" + RandomString.make(4))
                            .orderFace(OrderFace.LEGAL)
                            .build())
                    .limit(2)
                    .toList();

            user = User
                    .builder()
                    .email("vl@mail.ru")
                    .birthday(new Birthday(LocalDate.of(1999, 9, 13)))
                    .surname("Богатов")
                    .name("Владислав")
                    .telephone("+7999999999")
                    .orders(orderList)
                    .build();

            userOrder = new UserOrder("{\"Userinfo\":\"User test\"}");

            order = Order.builder().name("Заказ " + RandomString.make(3))
                    .orderFace(OrderFace.LEGAL).build();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void createOrder(){
        session.saveOrUpdate(order);
    }

    @Test
    public void deleteOrder(){
        session.delete(order);
    }

    @Test
    public void createUser(){
        session.saveOrUpdate(user);
    }

    @Test
    public void createUserOrder(){
        session.saveOrUpdate(userOrder);
    }

    @AfterEach
    public void stop(){
        session.getTransaction().commit();
        session.close();
    }
}