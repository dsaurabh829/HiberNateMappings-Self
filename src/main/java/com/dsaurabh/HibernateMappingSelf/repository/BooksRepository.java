package com.dsaurabh.HibernateMappingSelf.repository;

import com.dsaurabh.HibernateMappingSelf.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BooksRepository extends JpaRepository<Books, UUID> {

    Optional<Books> findByBookName(String name);

    @Query(value = "select b from Books b where bookId = :id")
    Optional<Books> findById(@Param("id") UUID id);
}
