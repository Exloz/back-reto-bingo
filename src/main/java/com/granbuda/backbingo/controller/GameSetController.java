package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.GameSetResponse;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.service.GameSetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/gameset")
public class GameSetController {

    private final GameSetService gameSetService;

    public GameSetController(GameSetService gameSetService) {
        this.gameSetService = gameSetService;
    }

    @GetMapping("/create")
    public ResponseEntity<GameSetResponse> createGameSet(){
        try{
            return new ResponseEntity<>(gameSetService.createNewGameSet(), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
