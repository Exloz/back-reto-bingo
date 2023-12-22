package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createWithBingoTable")
    public ResponseEntity<UserResponse> createUserWithBingoTable(@RequestBody UserRequest userRequest){
        try{
            return new ResponseEntity<UserResponse>(userService.createUserWithBingoTable(userRequest), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
