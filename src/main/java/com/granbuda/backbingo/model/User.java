package com.granbuda.backbingo.model;

import java.util.List;

public class User {

    private String Id;
    private String name;
    private List<BingoTable> bingoTableList;

    public User() {
    }

    public User(String id, String name, List<BingoTable> bingoTableList) {
        Id = id;
        this.name = name;
        this.bingoTableList = bingoTableList;
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

    public List<BingoTable> getBingoTableList() {
        return bingoTableList;
    }

    public void setBingoTableList(List<BingoTable> bingoTableList) {
        this.bingoTableList = bingoTableList;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", bingoTableList=" + bingoTableList +
                '}';
    }
}
