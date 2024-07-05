package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
import com.bookStore.bookStore.data.dto.requests.UpdateGenreRequest;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.data.repositories.GenreRepository;
import com.bookStore.bookStore.exceptions.GenreNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
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
        return Optional.ofNullable(genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id)));
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre updateGenre(Long id, UpdateGenreRequest request) {
        Genre existingGenre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id));

        existingGenre.setName(request.getName());

        if (request.getBooks() != null) {
            existingGenre.setBooks(request.getBooks());
        }

        return genreRepository.save(existingGenre);
    }


    @Override
    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id));
        genreRepository.delete(genre);
    }
}
