package com.example.be_project.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_status")
    private String bookStatus;

    @Column(name = "book_price")
    private Double bookPrice;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_image", columnDefinition = "TEXT")
    private String bookImage;

    @Column(name = "book_page_number")
    private Integer bookPageNumber;

    @Column(name = "book_weight")
    private Double bookWeight;

    @Column(name = "book_cover_type")
    private String bookCoverType;

    @Column(name = "book_quantity")
    private Integer bookQuantity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getter and setter methods
}
