package com.girllead.spring_data_jpa.service.impl;

import com.girllead.spring_data_jpa.enums.Tag;
import com.girllead.spring_data_jpa.dto.BookDto;
import com.girllead.spring_data_jpa.model.Book;
import com.girllead.spring_data_jpa.repo.BookRepo;
import com.girllead.spring_data_jpa.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepo bookRepo;

    @Override
    public String save(BookDto book) {
        Book bookEntity = new Book();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPrice(book.getPrice());
//        BeanUtils.copyProperties(book, bookEntity);

        bookEntity = bookRepo.save(bookEntity);
        return String.format("The Book titled %s with ID: %d has been saved", bookEntity.getTitle(), bookEntity.getId());
    }

    @Override
    public List<BookDto> findAll() {
//        return List.of(bookRepo.findAll().iterator().next());

        List<BookDto> bookDtoList = new ArrayList<>();
        Iterable<Book> books = bookRepo.findAll();

        for (Book book : books) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            bookDto.setTag(Tag.NEW);

            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public BookDto findByName(String name) {
        return null;
    }

    @Override
    public List<BookDto> searchByName(String name) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public String updateBookPrice(Long id, Double price) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPrice(price);
            bookRepo.save(book);
            return "The Book titled " + book.getTitle() + " has been updated to " + price;
        }
        else {
            return "Book with ID: " + id + " not found";
        }
    }
}
