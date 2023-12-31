package com.example.be_project.api;

import com.example.be_project.model.Book;
import com.example.be_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<Book> bookList = bookService.findAllBooks();

            if (bookList.isEmpty()) {
                return new ResponseEntity<>("Danh sách sách trống", HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception e) {
            // Ghi log lỗi ở đây
            e.printStackTrace();
            return new ResponseEntity<>("Đã xảy ra lỗi nội bộ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
