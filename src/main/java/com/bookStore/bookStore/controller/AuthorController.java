package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.data.dto.requests.CreateAuthorRequest;
import com.bookStore.bookStore.data.dto.requests.UpdateAuthorRequest;
import com.bookStore.bookStore.data.dto.response.CreateAuthorResponse;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.exceptions.AuthorNotFoundException;
import com.bookStore.bookStore.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorService.getAuthorById(id);
        Author author = optionalAuthor.orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
        return ResponseEntity.ok(author);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAuthor( @RequestBody CreateAuthorRequest request) {
        Author createdAuthor = authorService.createAuthor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id,@RequestBody CreateAuthorRequest request) {
        Author updatedAuthor = authorService.updateAuthor(id, request);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
}

