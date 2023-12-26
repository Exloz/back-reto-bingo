package com.granbuda.backbingo.model;

public class User {

    private String userName;
    private BingoTable bingoTable;

    public User() {

    }

    public User(String userName, BingoTable bingoTable) {
        this.userName = userName;
        this.bingoTable = bingoTable;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BingoTable getBingoTable() {
        return bingoTable;
    }

    public void setBingoTable(BingoTable bingoTable) {
        this.bingoTable = bingoTable;
    }

}
