package com.example.be_project.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "supplier_id") // thông qua khóa ngoại supplier_id
    private Supplier supplier;

    @ManyToOne
    @JoinColumn (name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    @Column(name = "book_quantity")
    private int bookQuantity;
    // Getter and setter methods
}
