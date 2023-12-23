package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.model.dto.GameSetResponse;
import com.granbuda.backbingo.repository.GameSetRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameSetService {

    private final GameSetRepository repository;
    private final Random random = new Random();

    public GameSetService(GameSetRepository repository) {
        this.repository = repository;
    }


    public GameSetResponse createNewGameSet(){
        GameSet optionalGameSet = repository.findByIsActiveGameTrue();
        GameSetResponse gameSetResponse = new GameSetResponse();

        if (optionalGameSet == null) {
            GameSet gameSet = new GameSet();
            GameSet newGameSet = repository.save(gameSet);
            gameSetResponse.setId(newGameSet.getId());
            gameSetResponse.setActiveGame(newGameSet.getActiveGame());
            return gameSetResponse;
        }
        gameSetResponse.setId(optionalGameSet.getId());
        gameSetResponse.setActiveGame(optionalGameSet.getActiveGame());
        return gameSetResponse;
    }


//
//    private List<Cell> createUserBingoCells(){
//        List<Cell> cellList = new ArrayList<>();
//        Set<Integer> usedNumbers = new HashSet<>();
//
//        for (int i = 0; i < 25; i++) {
//            int baseNumber = (i / 5) * 15 + 1;
//            int number;
//            do {
//                number = generateRandomIntInRange(baseNumber);
//            } while (usedNumbers.contains(number));
//            usedNumbers.add(number);
//            Cell cell = new Cell();
//            cell.setNumber(number);
//            cell.setCoordinate(i + 1);
//            cellList.add(cell);
//        }
//        return cellList;
//    }
//
//    private int generateRandomIntInRange(int baseNumber) {
//        return random.nextInt(15) + baseNumber;
//    }
}
