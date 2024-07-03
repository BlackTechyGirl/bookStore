package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateAuthorRequest;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author updateAuthor(Long id, CreateAuthorRequest request) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setFirstName(request.getFirstName());
            existingAuthor.setLastName(request.getLastName());
            existingAuthor.setBiography(request.getBiography());
            existingAuthor.setBooks(request.getBooks());
            return authorRepository.save(existingAuthor);
        }
        return null;
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
