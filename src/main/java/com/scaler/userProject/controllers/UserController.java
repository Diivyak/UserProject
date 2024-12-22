package com.scaler.userProject.controllers;

import com.scaler.userProject.exceptions.UserNotExistsException;
import com.scaler.userProject.models.User;
import com.scaler.userProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(@Qualifier("UserServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity<List<User>>  response = new ResponseEntity<>(
                userService.getAllUsers(), HttpStatus.NOT_FOUND
        );
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id") Long id) throws UserNotExistsException {
//        try {
        return new ResponseEntity<>(
                userService.getSingleUser(id), HttpStatus.OK);
//        }
//        catch (ArithmeticException exception) {
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        }
//        throw new RuntimeException("Something went wrong");
//        return userService.getSingleProduct(id);
    }
    @PostMapping()
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,  @RequestBody User user) {

        return userService.updateUser(id, user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
