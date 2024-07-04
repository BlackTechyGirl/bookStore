package com.bookStore.bookStore.services;


import com.bookStore.bookStore.data.dto.requests.CreateBookRequest;
import com.bookStore.bookStore.data.dto.response.BookResponse;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.model.Book;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.data.repositories.BookRepository;
import com.bookStore.bookStore.exceptions.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceImplTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    void setUp() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setBiography("Biography");

        Genre genre = new Genre();
        genre.setName("Fiction");

        book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPublisher("Test Publisher");
        book.setAuthor(author);
        book.setGenre(genre);
        book.setYearPublished(2021);

        bookRepository.save(book);
    }

    @Test
    void testCreateBook() {
        CreateBookRequest request = new CreateBookRequest();
        request.setTitle("New Book");
        request.setIsbn("0987654321");
        request.setPublisher("New Publisher");
        request.setAuthor(book.getAuthor());
        request.setGenre(book.getGenre());
        request.setYearPublished(2022);

        Book createdBook = bookService.createBook(request);

        assertEquals("New Book", createdBook.getTitle());
    }

    @Test
    void testGetBookById() {
        BookResponse foundBook = bookService.getBookById(book.getId());

        assertEquals(book.getTitle(), foundBook.getTitle());
    }

    @Test
    void testUpdateBook() {
        CreateBookRequest request = new CreateBookRequest();
        request.setTitle("Updated Book");
        request.setIsbn("1111111111");
        request.setPublisher("Updated Publisher");
        request.setAuthor(book.getAuthor());
        request.setGenre(book.getGenre());
        request.setYearPublished(2023);

        BookResponse updatedBook = bookService.updateBook(book.getId(), request);

        assertEquals("Updated Book", updatedBook.getTitle());
    }

    @Test
    void testDeleteBook() {
        bookService.deleteBook(book.getId());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(book.getId()));
    }
}
