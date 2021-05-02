package com.bla6.error;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class OompaError extends Exception {

    private String id = UUID.randomUUID().toString();

    private HttpStatus code;

    private String message;

    public OompaError(final HttpStatus code, final String message) {
        this.code = code;
        this.message = message;
    }
}
