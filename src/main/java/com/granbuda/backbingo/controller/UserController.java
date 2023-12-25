package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.UserListResponse;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public ResponseEntity<UserListResponse> listUsers(){

        try{
            return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        System.out.println(userRequest);
        try{
            return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
