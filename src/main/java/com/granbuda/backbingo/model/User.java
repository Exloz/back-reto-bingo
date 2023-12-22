package com.granbuda.backbingo.model;

import java.util.List;

public class User {

    private String Id;
    private String name;
    private List<UserBingoTable> userBingoTableList;

    public User() {
    }

    public User(String id, String name, List<UserBingoTable> userBingoTableList) {
        Id = id;
        this.name = name;
        this.userBingoTableList = userBingoTableList;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", bingoTableList=" + userBingoTableList +
                '}';
    }
}
