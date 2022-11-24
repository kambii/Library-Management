package com.example.librarymanagement.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "book_sequence")

    @Column(name = "id")
    private Long id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "serial_name")
    private String serialName;
    @Column(name = "description")
    private String description;

    public Book( String isbn, String bookName, String serialName, String description) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.serialName = serialName;
        this.description = description;
    }

    public Book(Long id, String isbn, String bookName, String serialName, String description) {
        this.id = id;
        this.isbn = isbn;
        this.bookName = bookName;
        this.serialName = serialName;
        this.description = description;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", serialName='" + serialName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
