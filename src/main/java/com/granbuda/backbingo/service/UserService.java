package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.model.User;
import com.granbuda.backbingo.model.dto.UserListResponse;
import com.granbuda.backbingo.model.dto.UserRequest;
import com.granbuda.backbingo.model.dto.UserResponse;
import com.granbuda.backbingo.repository.GameSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final GameSetRepository repository;

    public UserService(GameSetRepository repository) {
        this.repository = repository;
    }

    public UserResponse createUser(UserRequest userRequest){
        Optional<GameSet> activeGameSet = repository.findById(userRequest.getGameSetId());
        User user = new User();
        user.setUserName(userRequest.getUserName());
        activeGameSet.get().addUser(user);
        repository.save(activeGameSet.get());
        return new UserResponse(
                user.getUserName(),
                activeGameSet.get().getId()
        );
    }

    public UserListResponse listUsers(){
        GameSet optionalGameSet = repository.findByIsActiveGameTrue();
        UserListResponse userListResponse = new UserListResponse();

        List<User> userList = optionalGameSet.getUserList();
        for(User user: userList){
            userListResponse.addUser(user.getUserName());
        }

        return userListResponse;
    }

}
