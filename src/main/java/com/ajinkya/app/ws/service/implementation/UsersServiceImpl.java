package com.ajinkya.app.ws.service.implementation;

import com.ajinkya.app.ws.exceptions.UsersServiceException;
import com.ajinkya.app.ws.io.dao.DAO;
import com.ajinkya.app.ws.io.dao.implementation.MySqlDAO;
import com.ajinkya.app.ws.service.UsersService;
import com.ajinkya.app.ws.shared.dto.UserDTO;
import com.ajinkya.app.ws.ui.model.response.ErrorMessages;
import com.ajinkya.app.ws.utils.UserProfileUtils;

public class UsersServiceImpl implements UsersService {

    private UserProfileUtils userProfileUtils = new UserProfileUtils();
    private DAO database;

    public UsersServiceImpl() {
        this.database = new MySqlDAO();
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO();

        // Validate the required fields
        userProfileUtils.validateRequiredFields(user);

        // Check if user already exists
        UserDTO existingUser = this.getUserByUserName(user.getEmail());
        if (existingUser != null) {
            throw new UsersServiceException(
                    ErrorMessages.RECORD_ALREADY_EXISTS.name()
            );
        }

        return returnValue;
    }

    private UserDTO getUserByUserName(String userEmail) {
        UserDTO userDto = null;

        if (userEmail == null || userEmail.isEmpty()) {
            return  userDto;
        }

        // connect to database
        try {
            this.database.openConnection();
            userDto = this.database.getUserByUserName(userEmail);
        } finally {
            this.database.closeConnection();
        }

        return userDto;
    }
}
