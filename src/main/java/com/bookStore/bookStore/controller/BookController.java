package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.data.dto.requests.CreateBookRequest;
import com.bookStore.bookStore.data.dto.response.BookResponse;
import com.bookStore.bookStore.services.AuthorService;
import com.bookStore.bookStore.services.BookService;
import com.bookStore.bookStore.services.GenreService;
import com.bookStore.bookStore.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest request) {
        BookResponse createdBook = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Book created successfully", true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        BookResponse book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        List<BookResponse> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody CreateBookRequest request) {
        BookResponse updatedBook = bookService.updateBook(id, request);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new ApiResponse("Book deleted successfully", true));
    }
}
