package com.bookStore.bookStore.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAuthorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private boolean isSuccess;
    private HttpStatus status;
}
