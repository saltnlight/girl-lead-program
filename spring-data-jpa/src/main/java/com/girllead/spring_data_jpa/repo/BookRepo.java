package com.girllead.spring_data_jpa.repo;

import com.girllead.spring_data_jpa.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
    Book findBooksByAuthorAndTitle(String author, String title);
}
