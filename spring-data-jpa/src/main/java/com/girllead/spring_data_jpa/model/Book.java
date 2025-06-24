package com.girllead.spring_data_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {
    private String title;
    private String author;
    private Double price;
    @Id
    @GeneratedValue
    private Long id;

}
