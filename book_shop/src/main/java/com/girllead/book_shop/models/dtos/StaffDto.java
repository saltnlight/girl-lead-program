package com.girllead.book_shop.models.dtos;

import com.girllead.book_shop.models.enums.EmploymentLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
    private Long id;
    private String role;
    private String firstName;
    private String surname;
    private Integer age;
    private EmploymentLevel employmentLevel;
}
