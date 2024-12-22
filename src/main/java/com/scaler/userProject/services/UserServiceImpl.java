package com.scaler.userProject.services;

import com.scaler.userProject.exceptions.UserNotExistsException;
import com.scaler.userProject.models.User;
import com.scaler.userProject.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    private UserRespository userRespository;

    @Autowired
    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }
    @Override
    public User getSingleUser(Long id) throws UserNotExistsException {
        Optional<User> userOptional = userRespository.findById(id);

        if(userOptional.isEmpty()) {
            throw new UserNotExistsException("Product with id  does not exists");
        }

        User user = userOptional.get();
        return user;
    }

    @Override
    public User addNewUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRespository.findById(id);
        if(userOptional.isEmpty()) throw new RuntimeException();
        User savedUser = userOptional.get();

        if(user.getName() != null) {
            savedUser.setName(user.getName());
        }
        if(user.getEmail() != null) {
            savedUser.setEmail(user.getEmail());
        }
        if(user.getMobileNumber() != null) {
            savedUser.setMobileNumber(user.getMobileNumber());
        }
        return userRespository.save(savedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRespository.deleteById(id);
    }
}
