package com.bookStore.bookStore.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.ErrorResponse;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "ISBN is mandatory")
    private String isbn;

    @NotBlank(message = "Publisher is mandatory")
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull(message = "Author is mandatory")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    @NotNull(message = "Genre is mandatory")
    private Genre genre;

    private int yearPublished;



}
