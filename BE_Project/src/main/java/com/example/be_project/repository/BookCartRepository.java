package com.example.be_project.repository;

import com.example.be_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCartRepository extends JpaRepository<Book, Integer> {
    Book getById(Integer id);
}
