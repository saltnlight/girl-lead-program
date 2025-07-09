package com.girllead.book_shop.models.entities;

import com.girllead.book_shop.models.enums.BookStatus;
import com.girllead.book_shop.models.enums.BookTag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Double price;
    private Integer quantity;
    private String description;

    @Transient
    private BookTag bookTag;
    @Enumerated(EnumType.ORDINAL)
    private BookStatus status;
}
