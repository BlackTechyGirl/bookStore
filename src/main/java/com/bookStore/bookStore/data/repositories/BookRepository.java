package com.bookStore.bookStore.data.repositories;

import com.bookStore.bookStore.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
