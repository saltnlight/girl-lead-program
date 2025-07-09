package com.girllead.book_shop.models.entities;

import com.girllead.book_shop.models.enums.EmploymentLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "staffs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String role;
    private String firstName;
    private String surname;
    private Integer age;
    private EmploymentLevel employmentLevel;
    private Integer status;
}
