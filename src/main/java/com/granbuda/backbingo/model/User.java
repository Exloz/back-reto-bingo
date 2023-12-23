package com.granbuda.backbingo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class User {

    private String id;
    private String name;
    private List<UserBingoTable> userBingoTableList;

    public User() {
    }

    public User(String id, String name, List<UserBingoTable> userBingoTableList) {
        this.id = id;
        this.name = name;
        this.userBingoTableList = userBingoTableList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserBingoTable> getBingoTableList() {
        return userBingoTableList;
    }

    public void setBingoTableList(List<UserBingoTable> userBingoTableList) {
        this.userBingoTableList = userBingoTableList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bingoTableList=" + userBingoTableList +
                '}';
    }
}
