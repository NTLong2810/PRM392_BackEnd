package com.example.be_project.service;

import com.example.be_project.model.Book;
import com.example.be_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book bookDetail(int bookId){
        return bookRepository.findById(bookId);
    }
}
