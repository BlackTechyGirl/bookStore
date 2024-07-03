package com.bookStore.bookStore.data.dto.requests;

import com.bookStore.bookStore.data.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAuthorRequest {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("biography")
    private String biography;

    @JsonProperty("book(s)")
    private Set<Book> books;
}
