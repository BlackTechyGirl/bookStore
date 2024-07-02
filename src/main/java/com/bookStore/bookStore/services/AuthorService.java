package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author cycle);
    Author getAuthorById(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
