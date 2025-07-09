package com.girllead.book_shop.service;

import com.girllead.book_shop.exceptions.EntityInsufficientException;
import com.girllead.book_shop.exceptions.EntityNotFound;
import com.girllead.book_shop.models.dtos.BookDto;
import com.girllead.book_shop.models.dtos.SoldBookDto;
import com.girllead.book_shop.models.entities.Book;
import com.girllead.book_shop.repo.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookDto stockBook(BookDto bookDto) {
        Book book;
        if (bookDto.getId() != null && bookRepository.findById(bookDto.getId()).isPresent()) {
            bookRepository.updateQuantity(bookDto.getId(), bookDto.getQuantity());
            return bookDto;
        } else if (bookDto.getId() != null  && bookRepository.findById(bookDto.getId()).isEmpty()) {
            throw new EntityNotFound("Book with id " + bookDto.getId() + " not found");
        } else {
            if (bookDto.getQuantity() <= 0)
                throw new EntityInsufficientException("A new book must be more than 0");
            book = bookRepository.save(BookDto.from(bookDto));
        }
        BookDto response = new BookDto();
        BeanUtils.copyProperties(book, response);
        return response;
    }

    @Override
    public void sellBook(SoldBookDto soldBookDto) {

    }

    @Override
    public void lendBook(SoldBookDto soldBookDto) {

    }

    @Override
    public List<Book> viewBookShop() {
        return bookRepository.findAll();
    }

    @Override
    public BookDto viewBookById(Long id) {
        return bookRepository.findBookDtoById(id).orElseThrow(
                () -> new EntityNotFound("Book with id " + id + " not found")
        );
    }

    @Override
    public BookDto viewBookByTitle(String title) {
        return bookRepository.findBookDtoByTitle(title).orElseThrow(
                () -> new EntityNotFound("Book with title " + title + " not found")
        );
    }

}
