package lk.ijse.pos_system.util;

import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.OrderItem;
import lk.ijse.pos_system.entity.Order_t;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order_t.class)
                .addAnnotatedClass(OrderItem.class);

        sessionFactory =configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration():factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }


}
