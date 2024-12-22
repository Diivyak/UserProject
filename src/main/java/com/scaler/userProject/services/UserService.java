package com.scaler.userProject.services;

import com.scaler.userProject.exceptions.UserNotExistsException;
import com.scaler.userProject.models.User;

import java.util.List;

public interface UserService {
    User getSingleUser(Long id) throws UserNotExistsException;

    User addNewUser(User user);

    User updateUser(Long id, User user);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
