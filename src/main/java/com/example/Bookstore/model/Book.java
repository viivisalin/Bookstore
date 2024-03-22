package com.example.Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;

    @ManyToOne
    @JsonIgnoreProperties ("books")
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(Long bookid, String title, String author, int publicationYear, Category category, String isbn, double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.category = category;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getBookid() {
        return bookid;
    }
    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    /*public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }*/
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + /* " category =" + this.getCategory() +*/"]";
    }

    
    
}
