package com.test_crud_spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SiswaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public SiswaNotFoundException(String message) {
        this.message = message;
    }
}
