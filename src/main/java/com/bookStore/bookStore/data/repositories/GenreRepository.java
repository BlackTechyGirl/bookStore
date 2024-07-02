package com.bookStore.bookStore.data.repositories;

import com.bookStore.bookStore.data.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
