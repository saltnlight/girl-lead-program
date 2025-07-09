package com.girllead.book_shop.repo;

import com.girllead.book_shop.models.dtos.BookDto;
import com.girllead.book_shop.models.entities.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select new com.girllead.book_shop.models.dtos.BookDto(" +
            "bk.id, bk.title, bk.author, bk.publisher, bk.price, bk.description, bk.status) " +
            "from books bk where bk.id = :id")
    Optional<BookDto> findBookDtoById(@Param("id") Long id);

    @Query("select new com.girllead.book_shop.models.dtos.BookDto(" +
            "bk.id, bk.title, bk.author, bk.publisher, bk.price, bk.description, bk.status) " +
            "from books bk where bk.title = :title")
    Optional<BookDto> findBookDtoByTitle(@Param("title") String title);

    @Transactional
    @Modifying
    @Query("UPDATE books bk set bk.quantity = :qty where bk.id = :id")
    void updateQuantity(@Param("id") Long id, @Param("qty") Integer qty);
}
