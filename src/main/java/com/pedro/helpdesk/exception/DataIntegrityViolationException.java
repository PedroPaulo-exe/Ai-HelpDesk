package com.pedro.helpdesk.exception;

public class DataIntegrityViolationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String mensage, Throwable cause) {
        super(mensage, cause);
    }
    public DataIntegrityViolationException(String mensage) {
        super(mensage);
    }
}
