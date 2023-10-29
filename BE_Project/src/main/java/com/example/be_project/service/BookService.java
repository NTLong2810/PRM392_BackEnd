package com.example.be_project.service;

import com.example.be_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Object[]> findAllBooks() {
        return bookRepository.findAllBook();
    }

    public Object[] bookDetail(int bookId){
        List<Object[]> result = bookRepository.findBookDetailById(bookId);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
