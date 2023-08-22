package com.ufcg.es.healthtrack.exceptions;

public class InvalidCredentialsException extends  RuntimeException {
    private static final long serialVersionUID = -2558524431457472634L;

    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
