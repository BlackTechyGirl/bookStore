package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
import com.bookStore.bookStore.data.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre createGenre(CreateGenreRequest request);

    Optional<Genre> getGenreById(Long id);

    List<Genre> getAllGenres();

    Genre updateGenre(Long id, CreateGenreRequest request);

    void deleteGenre(Long id);
}
