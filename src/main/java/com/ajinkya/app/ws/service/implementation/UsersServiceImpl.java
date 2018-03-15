package com.ajinkya.app.ws.service.implementation;

import com.ajinkya.app.ws.service.UsersService;
import com.ajinkya.app.ws.shared.dto.UserDTO;
import com.ajinkya.app.ws.utils.UserProfileUtils;

public class UsersServiceImpl implements UsersService {

    private UserProfileUtils userProfileUtils = new UserProfileUtils();

    @Override
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO();

        // Validate the required fields
        userProfileUtils.validateRequiredFields(user);

        // Check if user already exists



        return returnValue;
    }
}
