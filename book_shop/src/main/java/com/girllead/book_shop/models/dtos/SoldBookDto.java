package com.girllead.book_shop.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoldBookDto {
    private  Long id;
    private Double price;
    private Integer quantity;
}
