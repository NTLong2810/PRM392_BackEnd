package com.example.be_project.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Book_Author")
public class Book_Author {
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "author_id")
    private int authorId;
    // Getter and setter methods
}
