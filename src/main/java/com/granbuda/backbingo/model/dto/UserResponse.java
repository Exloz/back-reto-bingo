package com.granbuda.backbingo.model.dto;

import com.granbuda.backbingo.model.Cell;

import java.util.List;

public class UserResponse {
    private String gameSetId;
    private String userName;

    public UserResponse(String gameSetId, String userName) {
        this.gameSetId = gameSetId;
        this.userName = userName;
    }

    public String getGameSetId() {
        return gameSetId;
    }

    public void setGameSetId(String gameSetId) {
        this.gameSetId = gameSetId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
