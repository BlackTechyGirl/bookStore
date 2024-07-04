package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateBookRequest;
import com.bookStore.bookStore.data.dto.response.BookResponse;
import com.bookStore.bookStore.data.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(CreateBookRequest request);

    BookResponse getBookById(Long id);

    List<BookResponse> getAllBooks();

    BookResponse updateBook(Long id, CreateBookRequest request);

    void deleteBook(Long id);
}
