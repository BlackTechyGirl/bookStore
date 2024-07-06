package com.bookStore.bookStore.services;


import com.bookStore.bookStore.data.dto.requests.CreateBookRequest;
import com.bookStore.bookStore.data.dto.response.BookResponse;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.model.Book;
import com.bookStore.bookStore.data.model.Genre;
import com.bookStore.bookStore.data.repositories.AuthorRepository;
import com.bookStore.bookStore.data.repositories.BookRepository;
import com.bookStore.bookStore.data.repositories.GenreRepository;
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

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    private Book book;
    private Author author;
    private Genre genre;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setBiography("Biography");
        authorRepository.save(author);

        genre = new Genre();
        genre.setName("Fiction");
        genreRepository.save(genre);

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
        request.setAuthor(author);
        request.setGenre(genre);
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

        // Creating new author and genre for the update request
        Author newAuthor = new Author();
        newAuthor.setFirstName("Jane");
        newAuthor.setLastName("Smith");
        newAuthor.setBiography("New Biography");
        authorRepository.save(newAuthor);

        Genre newGenre = new Genre();
        newGenre.setName("Non-Fiction");
        genreRepository.save(newGenre);

        request.setAuthor(newAuthor);
        request.setGenre(newGenre);
        request.setYearPublished(2023);

        BookResponse updatedBook = bookService.updateBook(book.getId(), request);

        assertEquals("Updated Book", updatedBook.getTitle());
        assertEquals("1111111111", updatedBook.getIsbn());
//        assertEquals("Updated Publisher", updatedBook.getPublisher());
        assertEquals("Jane", updatedBook.getAuthor().getFirstName());
        assertEquals("Non-Fiction", updatedBook.getGenre().getName());
        assertEquals(2023, updatedBook.getYearPublished());
    }

    @Test
    void testDeleteBook() {
        bookService.deleteBook(book.getId());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(book.getId()));
    }
}
