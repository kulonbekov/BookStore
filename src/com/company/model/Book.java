package com.company.model;

import java.math.BigDecimal;

public class Book {

    private Long id;
    private String name;
    private String author;
    private BigDecimal price;

    private Genre genre;
    private Store store;

    public Book() {
    }

    public Book(Long id, String name, String author, BigDecimal price, Genre genre, Store store) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                ", store=" + store +
                '}';
    }
}
