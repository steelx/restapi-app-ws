package com.ajinkya.app.ws.ui.entrypoints;


import com.ajinkya.app.ws.service.UsersService;
import com.ajinkya.app.ws.service.implementation.UsersServiceImpl;
import com.ajinkya.app.ws.shared.dto.UserDTO;
import com.ajinkya.app.ws.ui.model.request.CreateUserRequestModel;
import com.ajinkya.app.ws.ui.model.response.UserProfileRest;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersEntryPoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserProfileRest createUser(CreateUserRequestModel requestObject) {
        UserProfileRest returnValue = new UserProfileRest();

        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(requestObject, userDto);

        UsersService usersService = new UsersServiceImpl();
        UserDTO createdUserProfile = usersService.createUser(userDto);

        BeanUtils.copyProperties(createdUserProfile, returnValue);

        return returnValue;
    }
}
