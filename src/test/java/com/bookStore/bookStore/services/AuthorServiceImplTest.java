package com.bookStore.bookStore.services;

import com.bookStore.bookStore.data.dto.requests.CreateAuthorRequest;
import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.repositories.AuthorRepository;
import com.bookStore.bookStore.exceptions.AuthorNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setBiography("Biography");
        authorRepository.save(author);
    }

    @Test
    void testCreateAuthor() {
        CreateAuthorRequest request = new CreateAuthorRequest();
        request.setFirstName("Jane");
        request.setLastName("Smith");
        request.setBiography("New Biography");

        Author createdAuthor = authorService.createAuthor(request);

        assertEquals("Jane", createdAuthor.getFirstName());
        assertEquals("Smith", createdAuthor.getLastName());
    }

    @Test
    void testGetAuthorById() {
        Author foundAuthor = authorService.getAuthorById(author.getId());

        assertEquals(author.getFirstName(), foundAuthor.getFirstName());
    }

    @Test
    void testUpdateAuthor() {
        CreateAuthorRequest request = new CreateAuthorRequest();
        request.setFirstName("UpdatedFirstName");
        request.setLastName("UpdatedLastName");
        request.setBiography("Updated Biography");

        Author updatedAuthor = authorService.createAuthor(request);

        assertEquals("UpdatedFirstName", updatedAuthor.getFirstName());
        assertEquals("UpdatedLastName", updatedAuthor.getLastName());
    }

    @Test
    void testDeleteAuthor() {
        authorService.deleteAuthor(author.getId());

        assertThrows(AuthorNotFoundException.class, () -> authorService.getAuthorById(author.getId()));
    }
}
