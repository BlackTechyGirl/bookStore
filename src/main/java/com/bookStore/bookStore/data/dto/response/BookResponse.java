package com.bookStore.bookStore.data.dto.response;

import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private Author author;
    private Genre genre;
    private int yearPublished;
}
