package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
import com.bookStore.bookStore.data.dto.requests.UpdateGenreRequest;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.data.repositories.GenreRepository;
import com.bookStore.bookStore.exceptions.GenreNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

;import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreRepository genreRepository;

    private Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre();
        genre.setName("Fiction");
        genreRepository.save(genre);
    }

    @Test
    void testCreateGenre() {
        CreateGenreRequest request = new CreateGenreRequest();
        request.setName("Non-Fiction");

        Genre createdGenre = genreService.createGenre(request);

        assertEquals("Non-Fiction", createdGenre.getName());
    }

    @Test
    void testGetGenreById() {
        Genre foundGenre = genreService.getGenreById(genre.getId())
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + genre.getId()));

        assertEquals(genre.getName(), foundGenre.getName());
    }

    @Test
    void testUpdateGenre() {
        UpdateGenreRequest request = new UpdateGenreRequest();
        request.setName("Updated Fiction");

        Genre updatedGenre = genreService.updateGenre(genre.getId(), request);

        assertEquals("Updated Fiction", updatedGenre.getName());
    }


    @Test
    void testDeleteGenre() {
        genreService.deleteGenre(genre.getId());

        assertThrows(GenreNotFoundException.class, () -> genreService.getGenreById(genre.getId()));
    }
}
