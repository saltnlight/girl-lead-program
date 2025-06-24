package com.girllead.spring_data_jpa.service;

import com.girllead.spring_data_jpa.dto.BookDto;
import com.girllead.spring_data_jpa.model.Book;

import java.util.List;

public interface BookService {
    String save(BookDto book);
    List<BookDto> findAll();
    Book findById(Long id);
    BookDto findByName(String name);
    List<BookDto> searchByName(String name);
    void deleteById(Long id);
    String updateBookPrice(Long id, Double price);
}
