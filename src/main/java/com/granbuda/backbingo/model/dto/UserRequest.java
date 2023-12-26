package com.granbuda.backbingo.model.dto;

public class UserRequest {
    private String userName;
    private String gameSetId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameSetId() {
        return gameSetId;
    }

    public void setGameSetId(String gameSetId) {
        this.gameSetId = gameSetId;
    }
}
