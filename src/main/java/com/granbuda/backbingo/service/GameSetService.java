package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.Cell;
import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.model.User;
import com.granbuda.backbingo.model.UserBingoTable;
import com.granbuda.backbingo.model.dto.GameSetResponse;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
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
        Optional<GameSet> optionalGameSet = repository.findByIsActiveGameTrue();
        GameSetResponse gameSetResponse = new GameSetResponse();

        if (optionalGameSet.isEmpty()) {
            GameSet gameSet = new GameSet();
            GameSet newGameSet = repository.save(gameSet);
            gameSetResponse.setId(newGameSet.getId());
            gameSetResponse.setActiveGame(newGameSet.getActiveGame());
            return gameSetResponse;
        }
        gameSetResponse.setId(optionalGameSet.get().getId());
        gameSetResponse.setActiveGame(optionalGameSet.get().getActiveGame());
        return gameSetResponse;
    }

//    public UserResponse createUserWithBingoTable(UserRequest userRequest){
//        Optional<User> optionalUser = userRepository.findById(userRequest.getId());
//        User user = new User();
//
//        if (optionalUser.isEmpty()){
//            user.setId(userRequest.getId());
//            user.setName(userRequest.getName());
//            userRepository.save(user);
//        }else{
//            user = optionalUser.get();
//        }
//
//        UserBingoTable userBingoTable = new UserBingoTable();
//        userBingoTable.setUserId(user.getId());
//        userBingoTable.setGameSetId(userRequest.getGameSetId());
//        userBingoTable.setActive(true);
//        userBingoTable.setCellList(createUserBingoCells());
//
//        userBingoTableRepository.save(userBingoTable);
//
//        UserResponse response = new UserResponse();
//        response.setId(user.getId());
//        response.setName(user.getName());
//        response.setCellList(userBingoTable.getCellList());
//
//        return response;
//    }
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
