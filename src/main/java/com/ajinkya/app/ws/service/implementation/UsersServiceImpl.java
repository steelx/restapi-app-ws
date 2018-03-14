package com.ajinkya.app.ws.service.implementation;

import com.ajinkya.app.ws.service.UsersService;
import com.ajinkya.app.ws.shared.dto.UserDTO;
import com.ajinkya.app.ws.utils.UserProfileUtils;

public class UsersServiceImpl implements UsersService {

    UserProfileUtils userProfileUtils = new UserProfileUtils();

    @Override
    public UserDTO createUser(UserDTO userDto) {
        UserDTO returnValue = new UserDTO();

        // Validate the required fields

        // Check if user already exists

        return returnValue;
    }
}
