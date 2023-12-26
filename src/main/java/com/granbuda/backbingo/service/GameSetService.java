package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.BingoTable;
import com.granbuda.backbingo.model.Cell;
import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.model.User;
import com.granbuda.backbingo.model.dto.BingoBallotsResponse;
import com.granbuda.backbingo.model.dto.BingoTableResponse;
import com.granbuda.backbingo.model.dto.GameSetResponse;
import com.granbuda.backbingo.model.dto.UserListResponse;
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
        GameSet activeGameSet = repository.findByIsActiveGameTrue();
        GameSetResponse gameSetResponse = new GameSetResponse();

        if (activeGameSet == null) {
            GameSet gameSet = new GameSet();
            GameSet newGameSet = repository.save(gameSet);
            gameSetResponse.setId(newGameSet.getId());
            gameSetResponse.setActiveGame(newGameSet.getActiveGame());
            return gameSetResponse;
        }
        gameSetResponse.setId(activeGameSet.getId());
        gameSetResponse.setActiveGame(activeGameSet.getActiveGame());
        return gameSetResponse;
    }

    public BingoTableResponse createUserBingoCells(String userName){
        GameSet activeGameSet = repository.findByIsActiveGameTrue();
        BingoTableResponse bingoTableResponse = new BingoTableResponse();

        User user = activeGameSet.getUserList().stream()
                .filter(user1 -> user1.getUserName().equals(userName))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

        user.setBingoTable(createBingoTable());
        activeGameSet.addUser(user);
        repository.save(activeGameSet);

        bingoTableResponse.setCellList(user.getBingoTable().getCellList());
        bingoTableResponse.setIsActive(user.getBingoTable().getActive());

        return bingoTableResponse;

    }


    private BingoTable createBingoTable(){
        BingoTable bingoTable = new BingoTable();
        bingoTable.setActive(true);
        bingoTable.setCellList(generateUserBingoCells());

        return bingoTable;
    }



    private List<Cell> generateUserBingoCells(){
        List<Cell> cellList = new ArrayList<>();
        Set<Integer> usedNumbers = new HashSet<>();

        for (int i = 0; i < 25; i++) {
            int baseNumber = (i / 5) * 15 + 1;
            int number;
            do {
                number = generateRandomIntInRange(baseNumber);
            } while (usedNumbers.contains(number));
            usedNumbers.add(number);
            Cell cell = new Cell();
            cell.setNumber(number);
            cell.setCoordinate(i + 1);
            cellList.add(cell);
        }
        return cellList;
    }

    private int generateRandomIntInRange(int baseNumber) {
        return random.nextInt(15) + baseNumber;
    }

    public UserListResponse listUsers(){
        GameSet activeGameSet = repository.findByIsActiveGameTrue();
        UserListResponse userListResponse = new UserListResponse();

        List<User> userList = activeGameSet.getUserList();
        for(User user: userList){
            userListResponse.addUser(user.getUserName());
        }

        return userListResponse;
    }

}
