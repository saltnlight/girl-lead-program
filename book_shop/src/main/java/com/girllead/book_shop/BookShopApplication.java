package com.girllead.book_shop;

import com.girllead.book_shop.models.entities.Staff;
import com.girllead.book_shop.models.enums.EmploymentLevel;
import com.girllead.book_shop.repo.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StaffRepository staffRepository) {
        return args -> {
            if (staffRepository.findByRole("admin").isEmpty()) {
                Staff admin = new Staff(null, "admin", "Flora","Egwu", 29, EmploymentLevel.SENIOR, 1);
                staffRepository.save(admin);
            }
        };
    }
}
