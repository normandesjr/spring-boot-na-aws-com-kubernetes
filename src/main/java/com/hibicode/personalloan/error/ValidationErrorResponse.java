package com.hibicode.personalloan.error;

public class ValidationErrorResponse {

    private String field;
    private String message;
    private Object rejectedValue;

    public ValidationErrorResponse(String message) {
        this.message = message;
    }

    public ValidationErrorResponse(String field, String message, Object rejectedValue) {
        this(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

}
