package com.ajinkya.app.ws.exceptions;

public class UsersServiceException extends RuntimeException {

    private static final long serialVersionUID = -4397180833150871892L;

    public UsersServiceException(String message) {
        super(message);
    }
}
