package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "author_name")
    private String authorName;

    // Getter and setter methods
}