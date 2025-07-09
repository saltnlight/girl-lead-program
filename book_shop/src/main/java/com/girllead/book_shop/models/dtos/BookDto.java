package com.girllead.book_shop.models.dtos;

import com.girllead.book_shop.models.entities.Book;
import com.girllead.book_shop.models.enums.BookStatus;
import com.girllead.book_shop.models.enums.BookTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private  Long id;
    private String title;
    private String author;
    private String publisher;
    private Double price;
    private Integer quantity;
    private String description;
    private BookTag bookTag;
//    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public BookDto(Long id, String title, String author, String publisher, Double price, String description, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public static Book from(BookDto dto) {
        Book book = new Book();
        BeanUtils.copyProperties(dto, book);
        return book;
    }
}
