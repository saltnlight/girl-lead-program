package com.girllead.spring_data_jpa.controller;


import com.girllead.spring_data_jpa.dto.BookDto;
import com.girllead.spring_data_jpa.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private final BookService bookService;

    @PostMapping("")
    public String stockABook(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }

    @PatchMapping("/{id}/{price}")
    public String updatePrice(@PathVariable Long id, @PathVariable Double price) {
        return bookService.updateBookPrice(id, price);
    }

    @DeleteMapping("/{id}")
    public void deleteABook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("")
    public List<BookDto> listBooks() {
        return bookService.findAll();
    }


}
