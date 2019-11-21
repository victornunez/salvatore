package com.victornunez.salvatore.connector.exception;

import java.io.IOException;

public class MovieDBBadRequestException extends IOException {
    public MovieDBBadRequestException(String message) {
        super(message);
    }
}
