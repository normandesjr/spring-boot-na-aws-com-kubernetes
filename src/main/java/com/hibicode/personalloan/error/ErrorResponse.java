package com.hibicode.personalloan.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private List<ValidationErrorResponse> validationErrors;

    private ErrorResponse() {
        timestamp = LocalDateTime.now(Clock.systemUTC());
    }

    public ErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(FieldError fieldError) {
        addValidationError(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
    }

    private void addValidationError(String field, Object rejectedValue, String defaultMessage) {
        if (validationErrors == null) {
            validationErrors = new ArrayList<>();
        }

        validationErrors.add(new ValidationErrorResponse(field, defaultMessage, rejectedValue));
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ValidationErrorResponse> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationErrorResponse> validationErrors) {
        this.validationErrors = validationErrors;
    }

}
