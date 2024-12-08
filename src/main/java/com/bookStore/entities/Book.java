package com.bookStore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String price;

    // Constructor without 'id', as it is auto-generated
    public Book(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Default constructor for JPA
    public Book() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
    }
}
