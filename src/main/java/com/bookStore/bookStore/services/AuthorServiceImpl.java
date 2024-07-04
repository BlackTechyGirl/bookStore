package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateAuthorRequest;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.repositories.AuthorRepository;
import com.bookStore.bookStore.exceptions.AuthorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(CreateAuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setBiography(request.getBiography());
        author.setBooks(request.getBooks());
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }

    @Override
    public Author updateAuthor(Long id, CreateAuthorRequest request) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));

        existingAuthor.setFirstName(request.getFirstName());
        existingAuthor.setLastName(request.getLastName());
        existingAuthor.setBiography(request.getBiography());

        if (existingAuthor.getBooks() == null) {
            existingAuthor.setBooks(new HashSet<>());
        }
        existingAuthor.getBooks().clear();
        if (request.getBooks() != null) {
            existingAuthor.getBooks().addAll(request.getBooks());
            request.getBooks().forEach(book -> book.setAuthor(existingAuthor));
        }

        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
