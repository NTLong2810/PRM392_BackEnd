package com.example.be_project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Book_Author")
public class Book_Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "author_id")
    private int authorId;

    // Getter and setter methods
}