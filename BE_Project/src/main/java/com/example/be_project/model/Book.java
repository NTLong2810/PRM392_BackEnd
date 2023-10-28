package com.example.be_project.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_price")
    private double bookPrice;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_image")
    private String bookImage;

    @Column(name = "book_page_number")
    private int bookPageNumber;

    @Column(name = "book_cover_type")
    private String bookCoverType;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "publisher_id")
    private int publisherId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "book_quantity")
    private int bookQuantity;
    @ManyToMany
    @JoinTable(
            name = "Book_Author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    // Getter and setter methods
}
