package com.example.be_project.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "book_quantity")
    private int bookQuantity;

    // Getter and setter methods
}
