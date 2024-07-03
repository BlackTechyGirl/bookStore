package com.bookStore.bookStore.data.dto.requests;

import com.bookStore.bookStore.data.model.Author;
import com.bookStore.bookStore.data.model.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("genre")
    private Genre genre;

    @JsonProperty("year")
    private int yearPublished;
}
