package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration()
                .configure()
                .buildSessionFactory();

        Session session =
                factory.openSession();

        Transaction tx =
                session.beginTransaction();

        Book b =
                new Book(
                        "Java",
                        500
                );

        User u =
                new User(
                        "admin",
                        "123"
                );

        session.persist(b);

        session.persist(u);

        tx.commit();

        session.close();

        factory.close();

        System.out.println(
                "Inserted"
        );
    }
}