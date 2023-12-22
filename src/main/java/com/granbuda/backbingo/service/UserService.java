package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.Cell;
import com.granbuda.backbingo.model.User;
import com.granbuda.backbingo.model.UserBingoTable;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.repository.GameSetRepository;
import com.granbuda.backbingo.repository.UserBingoTableRepository;
import com.granbuda.backbingo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GameSetRepository gameSetRepository;
    private final UserBingoTableRepository userBingoTableRepository;

    public UserService(UserRepository userRepository, GameSetRepository gameSetRepository, UserBingoTableRepository userBingoTableRepository) {
        this.userRepository = userRepository;
        this.gameSetRepository = gameSetRepository;
        this.userBingoTableRepository = userBingoTableRepository;
    }

    public UserResponse createUserWithBingoTable(UserRequest userRequest){
        Optional<User> optionalUser = userRepository.findById(userRequest.getId());
        User user = new User();

        if (optionalUser.isEmpty()){
            user.setId(userRequest.getId());
            user.setName(userRequest.getName());
            userRepository.save(user);
        }else{
            user = optionalUser.get();
        }

        UserBingoTable userBingoTable = new UserBingoTable();
        userBingoTable.setUserId(user.getId());
        userBingoTable.setGameSetId(userRequest.getGameSetId());
        userBingoTable.setActive(true);
        userBingoTable.setCellList(createUserBingoCells());

        userBingoTableRepository.save(userBingoTable);

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setCellList(userBingoTable.getCellList());

        return response;
    }

    private List<Cell> createUserBingoCells(){
        List<Cell> cellList = new ArrayList<>();
        for (int i=0; i<5; i++){
            Cell cell = new Cell();
            cell.setNumber(generateRandomIntInRange(1));
            cell.setNumber(i+1);
            cellList.add(cell);
        }
        for (int i=5; i<10; i++){
            Cell cell = new Cell();
            cell.setNumber(generateRandomIntInRange(16));
            cell.setNumber(i+1);
            cellList.add(cell);
        }
        for (int i=10; i<15; i++){
            Cell cell = new Cell();
            cell.setNumber(generateRandomIntInRange(31));
            cell.setNumber(i+1);
            cellList.add(cell);
        }
        for (int i=15; i<20; i++){
            Cell cell = new Cell();
            cell.setNumber(generateRandomIntInRange(46));
            cell.setNumber(i+1);
            cellList.add(cell);
        }
        for (int i=20; i<25; i++){
            Cell cell = new Cell();
            cell.setNumber(generateRandomIntInRange(61));
            cell.setNumber(i+1);
            cellList.add(cell);
        }
        return cellList;
    }

    private int generateRandomIntInRange(Integer integer){
        Random random = new Random();
        return random.nextInt(15)+integer;
    }
}
