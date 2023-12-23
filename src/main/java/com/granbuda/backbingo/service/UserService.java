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

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GameSetRepository gameSetRepository;
    private final UserBingoTableRepository userBingoTableRepository;
    private final Random random = new Random();

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
}
