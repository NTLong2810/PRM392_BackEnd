package com.example.be_project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Book_Author")
public class Book_Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_author_id")
    private int bookAuthorId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getter and setter methods
}