package com.example.be_project.repository;

import com.example.be_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.book_id, b.book_image, b.book_title, b.book_price, b.book_status, a.author_name, c.category_name FROM Book b " +
            "LEFT JOIN Book_Author ba ON b.book_id = ba.book_id " +
            "LEFT JOIN Author a ON ba.author_id = a.author_id " +
            "LEFT JOIN Category c ON c.category_id = b.category_id ", nativeQuery = true)
    List<Object[]> findAllBook();
    @Query(value = "SELECT b.book_id, b.book_title, b.book_status, b.book_price, b.book_description, b.book_language, b.book_weight, b.book_image, b.book_year_publish, b.book_cover_type, b.book_page_number, s.supplier_name, p.publisher_name, c.category_name, se.seller_name, se.seller_phone, a.author_name FROM Book b " +
            "LEFT JOIN Book_Author ba ON b.book_id = ba.book_id " +
            "LEFT JOIN Author a ON ba.author_id = a.author_id " +
            "LEFT JOIN Supplier s ON s.supplier_id = b.supplier_id " +
            "LEFT JOIN Publisher p ON p.publisher_id = b.publisher_id " +
            "LEFT JOIN Category c ON c.category_id = b.category_id " +
            "LEFT JOIN Seller se ON se.seller_id = b.seller_id " +
            "WHERE b.book_id = :bookId", nativeQuery = true)
    List<Object[]> findBookDetailById(int bookId);
}
