package com.example.be_project.repository;

import com.example.be_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
//    @Query(value = "SELECT * FROM Book b \n" +
//            "LEFT JOIN Book_Author ba ON b.book_id = ba.book_id \n" +
//            "LEFT JOIN Author a ON ba.author_id = a.author_id \n" +
//            "LEFT JOIN Category c ON c.category_id = b.category_id ", nativeQuery = true)

    @Override
    List<Book> findAll();

    //    @Query(value = "SELECT * FROM Book b\n" +
//            "LEFT JOIN Book_Author ba ON b.book_id = ba.book_id\n" +
//            "LEFT JOIN Author a ON ba.author_id = a.author_id \n" +
//            "LEFT JOIN Supplier s ON s.supplier_id = b.supplier_id \n" +
//            "LEFT JOIN Publisher p ON p.publisher_id = b.publisher_id \n" +
//            "LEFT JOIN Category c ON c.category_id = b.category_id \n" +
//            "WHERE b.book_id = :bookId", nativeQuery = true)
    Book findById(int bookId);
}
