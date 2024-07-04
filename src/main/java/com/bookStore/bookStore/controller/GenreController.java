package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
import com.bookStore.bookStore.data.dto.requests.UpdateGenreRequest;
import com.bookStore.bookStore.data.dto.response.GenreResponse;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.exceptions.GenreNotFoundException;
import com.bookStore.bookStore.services.GenreService;
import com.bookStore.bookStore.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/genres")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/create")
    public ResponseEntity<?> createGenre(@RequestBody CreateGenreRequest request) {
        Genre createdGenre = genreService.createGenre(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Genre created successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable Long id, @RequestBody UpdateGenreRequest request) {
        genreService.updateGenre(id, request);
        return ResponseEntity.ok(new ApiResponse("Genre updated successfully", true));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok(new ApiResponse("Genre deleted successfully", true));
    }
}
