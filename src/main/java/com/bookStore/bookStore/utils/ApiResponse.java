package com.bookStore.bookStore.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private ZonedDateTime timeStamp;
    private HttpStatus statusCode;
    private String path;
    private Object data;
    private Boolean isSuccessful;

    public ApiResponse(String message, Boolean isSuccess) {
        this.timeStamp = ZonedDateTime.now();
        this.data = message;
        this.isSuccessful = isSuccess;
    }
}
