package com.granbuda.backbingo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "GameSets")
public class GameSet {
    @Id
    private String id;
    private List<Integer> ballots;
    private List<User> userList;

    public GameSet(String id, List<Integer> ballots, List<User> userList) {
        this.id = id;
        this.ballots = ballots;
        this.userList = userList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getBallots() {
        return ballots;
    }

    public void setBallots(List<Integer> ballots) {
        this.ballots = ballots;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
