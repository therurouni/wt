package com.example;

import jakarta.persistence.*;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String title;

  private int price;

  public Book() {}

  public Book(String title, int price) {

    this.title = title;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getPrice() {
    return price;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

