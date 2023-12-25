package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.Cell;
import com.granbuda.backbingo.model.dto.BingoTableResponse;
import com.granbuda.backbingo.model.dto.GameSetResponse;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.service.GameSetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create/bingotable/{userName}")
    public ResponseEntity<BingoTableResponse> createBingoTable(@PathVariable (value = "userName")String userName){
        try{
            return new ResponseEntity<>(gameSetService.createUserBingoCells(userName), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
