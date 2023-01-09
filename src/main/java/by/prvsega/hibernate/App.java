package by.prvsega.hibernate;

import by.prvsega.model.Item;
import by.prvsega.model.Passport;
import by.prvsega.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

           Person person = session.get(Person.class, 12);

           session.delete(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
