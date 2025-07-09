package com.girllead.book_shop.controller;

import com.girllead.book_shop.models.dtos.BookDto;
import com.girllead.book_shop.models.entities.Book;
import com.girllead.book_shop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("my-book-shop/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public ResponseEntity<BookDto> stockBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.stockBook(bookDto));
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> viewBookShop() {
        return new ResponseEntity<>(bookService.viewBookShop(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.viewBookById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("title/{title}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String title) {
        return new ResponseEntity<>(bookService.viewBookByTitle(title), HttpStatusCode.valueOf(200));
    }

}
