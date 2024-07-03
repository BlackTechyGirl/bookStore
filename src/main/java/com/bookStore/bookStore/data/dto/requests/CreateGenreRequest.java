package com.bookStore.bookStore.data.dto.requests;

import com.bookStore.bookStore.data.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateGenreRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("book(s)")
    @NotNull(message = "Books set cannot be null")
    private Set<Book> books;
}
