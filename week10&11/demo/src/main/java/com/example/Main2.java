package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main2 {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    Session session = factory.openSession();

    Transaction tx = session.beginTransaction();

    // CREATE

    Book b1 = new Book("Java", 500);

    session.persist(b1);

    // READ

    Book book = session.find(Book.class, 1);

    if (book != null) {

      System.out.println(book.getTitle());
    }

    // UPDATE

    Book updateBook = session.find(Book.class, 1);

    if (updateBook != null) {

      updateBook.setPrice(999);

      session.merge(updateBook);
    }

    // DELETE

    Book deleteBook = session.find(Book.class, 2);

    if (deleteBook != null) {

      session.remove(deleteBook);
    }

    tx.commit();

    session.close();

    factory.close();

    System.out.println("CRUD Operations Completed");
  }
}
