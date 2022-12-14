package com.example.SpringREST.controller;

import com.example.SpringREST.model.User;
import com.example.SpringREST.service.UserService;
import com.example.SpringREST.util.UserErrorResponse;
import com.example.SpringREST.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers(){
        return userService.findAll();// Jackson converts object to JSON
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.findOne(id);// Jackson converts object to JSON
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e){
        UserErrorResponse response = new UserErrorResponse(
                "User with this id wasn't found",
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
