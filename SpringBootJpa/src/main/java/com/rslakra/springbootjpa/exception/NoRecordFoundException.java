package com.rslakra.springbootjpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Sep 01, 2021 20:38:33
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends RuntimeException {

    /**
     * @param object
     */
    public NoRecordFoundException(final Object object) {
        super(String.format("No record found for %s!", Objects.toString(object)));
    }

    /**
     * Throws <code>NoRecordFoundException</code> with the given <code>pattern</code> and <code>objects</code>.
     *
     * @param pattern
     * @param objects
     */
    public NoRecordFoundException(final String pattern, final Object... objects) {
        super(String.format(String.format("No record found for %s!", Objects.toString(pattern)), objects));
    }

    /**
     * @param message
     * @param throwable
     */
    public NoRecordFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}