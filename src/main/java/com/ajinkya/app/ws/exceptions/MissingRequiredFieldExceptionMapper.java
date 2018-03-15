package com.ajinkya.app.ws.exceptions;

import com.ajinkya.app.ws.ui.model.response.ErrorMessage;
import com.ajinkya.app.ws.ui.model.response.ErrorMessages;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingRequiredFieldExceptionMapper implements ExceptionMapper<MissingRequiredFieldException> {

    @Override
    public Response toResponse(MissingRequiredFieldException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                ErrorMessages.MISSING_REQUIRED_FIELD.name(), "http://ajinkyaxjs.com");

        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
