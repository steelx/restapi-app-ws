package com.ajinkya.app.ws.exceptions;

public class MissingRequiredFieldException extends RuntimeException {

    private static final long serialVersionUID = 1490612091326288434L;

    public MissingRequiredFieldException(String message) {
        super(message);
    }

}
