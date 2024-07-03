package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.data.dto.requests.CreateGenreRequest;
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
        Genre genre = genreService.getGenreById(id)
                .orElseThrow(() -> new GenreNotFoundException("Genre not found with id: " + id));
        GenreResponse response = mapToGenreResponse(genre);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> genres = genreService.getAllGenres();
        List<GenreResponse> responses = genres.stream()
                .map(this::mapToGenreResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable Long id, @RequestBody CreateGenreRequest request) {
        Genre updatedGenre = genreService.updateGenre(id, request);
        GenreResponse response = mapToGenreResponse(updatedGenre);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok(new ApiResponse("Genre deleted successfully", true));
    }

    private GenreResponse mapToGenreResponse(Genre genre) {
        GenreResponse response = new GenreResponse();
        response.setId(genre.getId());
        response.setName(genre.getName());
        return response;
    }
}
