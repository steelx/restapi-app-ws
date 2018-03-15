package com.ajinkya.app.ws.exceptions;

import com.ajinkya.app.ws.ui.model.response.ErrorMessage;
import com.ajinkya.app.ws.ui.model.response.ErrorMessages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UsersServiceExceptionMapper implements ExceptionMapper<UsersServiceException> {

    @Override
    public Response toResponse(UsersServiceException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                ErrorMessages.RECORD_ALREADY_EXISTS.name(), "http://ajinkyaxjs.com");

        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
