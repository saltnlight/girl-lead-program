package com.girllead.book_shop.service;

import com.girllead.book_shop.models.dtos.BookDto;
import com.girllead.book_shop.models.dtos.SoldBookDto;
import com.girllead.book_shop.models.entities.Book;

import java.util.List;

public interface BookService {
    BookDto stockBook(BookDto bookDto);
    void sellBook(SoldBookDto soldBookDto);
    void lendBook(SoldBookDto soldBookDto);
    List<Book> viewBookShop();
    BookDto viewBookById(Long id);
    BookDto viewBookByTitle(String title);

}
