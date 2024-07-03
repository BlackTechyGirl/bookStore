package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateAuthorRequest;
import com.bookStore.bookStore.data.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(CreateAuthorRequest request);

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    public Author updateAuthor(Long id, CreateAuthorRequest request);
    void deleteAuthor(Long id);
}
