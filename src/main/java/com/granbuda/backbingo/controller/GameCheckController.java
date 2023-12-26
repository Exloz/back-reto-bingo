package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.GameCheckRequest;
import com.granbuda.backbingo.service.GameCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/check")
public class GameCheckController {

    private final GameCheckService checkService;

    public GameCheckController(GameCheckService checkService) {
        this.checkService = checkService;
    }

    @PostMapping("/winner")
    public ResponseEntity<Boolean> checkIfWinner (@RequestBody GameCheckRequest gameCheckRequest){
        try {
            return new ResponseEntity<>(checkService.checkWinner(gameCheckRequest.getCellList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
