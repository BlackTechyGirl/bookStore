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
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public Book createBook(CreateBookRequest request) {
        Author author = authorRepository.findById(request.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + request.getAuthor()));

        Genre genre = genreRepository.findById(request.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + request.getGenre()));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublisher(request.getPublisher());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setYearPublished(request.getYearPublished());

        return bookRepository.save(book);
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        return convertToBookResponse(book);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertToBookResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse updateBook(Long id, CreateBookRequest request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        Author author = authorRepository.findById(request.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + request.getAuthor()));

        Genre genre = genreRepository.findById(request.getAuthor().getId())
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + request.getGenre()));

        existingBook.setTitle(request.getTitle());
        existingBook.setAuthor(author);
        existingBook.setGenre(genre);
        existingBook.setYearPublished(request.getYearPublished());

        Book updatedBook = bookRepository.save(existingBook);
        return convertToBookResponse(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    private BookResponse convertToBookResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getAuthor(),
                book.getGenre(),
                book.getYearPublished()
        );
    }
}