package com.example.be_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "author_name")
    private String authorName;
    // Getter and setter methods
}