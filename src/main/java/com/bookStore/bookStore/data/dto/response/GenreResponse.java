package com.bookStore.bookStore.data.dto.response;

import com.bookStore.bookStore.data.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class GenreResponse {
    private Long id;
    private String name;
    private Set<Book> books;
}
