// Database Access Object
package com.ajinkya.app.ws.io.dao;


import com.ajinkya.app.ws.shared.dto.UserDTO;

public interface DAO {
    void openConnection();
    UserDTO getUserByUserName(String userName);
    void closeConnection();
}
