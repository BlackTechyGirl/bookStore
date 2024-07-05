package com.bookStore.bookStore.data.dto.requests;

import com.bookStore.bookStore.data.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGenreRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("books")
    private Set<Book> books;
}
