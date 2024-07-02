package com.bookStore.bookStore.data.repositories;

import com.bookStore.bookStore.data.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
