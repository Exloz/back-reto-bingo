package com.granbuda.backbingo.model.dto;

public class UserRequest {
    private String id;
    private String name;
    private String gameSetId;

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

    public String getGameSetId() {
        return gameSetId;
    }

    public void setGameSetId(String gameSetId) {
        this.gameSetId = gameSetId;
    }
}
