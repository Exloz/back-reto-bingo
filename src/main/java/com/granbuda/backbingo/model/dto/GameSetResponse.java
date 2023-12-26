package com.granbuda.backbingo.model.dto;

public class GameSetResponse {
    private String id;
    private Boolean isActiveGame;

    public GameSetResponse() {
    }

    public GameSetResponse(String id, Boolean isActiveGame) {
        this.id = id;
        this.isActiveGame = isActiveGame;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActiveGame() {
        return isActiveGame;
    }

    public void setActiveGame(Boolean activeGame) {
        isActiveGame = activeGame;
    }
}
