package com.simplon.enigma.controller;

import fr.formation.students.entities.ApiErrors;
import fr.formation.students.entities.ValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomControllerExeption extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex,
             HttpHeaders headers,
             HttpStatus status, WebRequest request) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<ValidationError> customErrors = new ArrayList<>();

        for(FieldError error: errors){
            String attributeName = error.getField();
            String errorCode = error.getCode();
            ValidationError customError = new ValidationError();
            customError.setAttributeName(attributeName);
            customError.setErrorCode(errorCode);
            customErrors.add(customError);
        }

        ApiErrors apiErrors = new ApiErrors();
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        apiErrors.setHttpcode(httpStatus.value());
        apiErrors.setTimestamp(LocalDateTime.now());
        apiErrors.setHttpMessage(httpStatus.getReasonPhrase());
        apiErrors.setTotalErrors(customErrors.size());
        apiErrors.setErrors(customErrors);

        return new ResponseEntity<Object>(apiErrors, headers, httpStatus);
    }
}
