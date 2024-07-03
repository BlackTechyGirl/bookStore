package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.data.repositories.GenreRepository;
import com.bookStore.bookStore.exceptions.GenreNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre createGenre(CreateGenreRequest request) {
        Genre genre = new Genre();
        genre.setName(request.getName());
        genre.setBooks(request.getBooks());
        return genreRepository.save(genre);
    }

    @Override
    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre updateGenre(Long id, CreateGenreRequest request) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id));
        genre.setName(request.getName());
        genre.setBooks(request.getBooks());
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id));
        genreRepository.delete(genre);
    }
}
