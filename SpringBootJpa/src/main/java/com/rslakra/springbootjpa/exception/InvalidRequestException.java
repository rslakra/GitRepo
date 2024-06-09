package com.rslakra.springbootjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Sep 01, 2021 20:19:28
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

    public static final String INVALID_REQUEST = "Invalid Request!";

    public InvalidRequestException() {
        this(INVALID_REQUEST);
    }

    /**
     * @param message
     */
    public InvalidRequestException(String message) {
        super(Objects.isNull(message) ? INVALID_REQUEST : message);
    }

    /**
     * Throws <code>InvalidRequestException</code> with the given <code>pattern</code> and <code>objects</code>.
     *
     * @param pattern
     * @param objects
     */
    public InvalidRequestException(final String pattern, final Object... objects) {
        super(String.format(pattern, objects));
    }

    /**
     * @param message
     * @param throwable
     */
    public InvalidRequestException(String message, Throwable throwable) {
        super(Objects.isNull(message) ? INVALID_REQUEST : message, throwable);
    }

    /**
     * @param throwable
     */
    public InvalidRequestException(Throwable throwable) {
        super(INVALID_REQUEST, throwable);
    }
}
