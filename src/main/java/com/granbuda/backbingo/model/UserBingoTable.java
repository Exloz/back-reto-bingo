package com.granbuda.backbingo.model;

import java.util.List;

public class UserBingoTable {
    private String id;
    private String userId;
    private String gameSetId;
    private List<Cell> cellList;
    private Boolean isActive;

    public UserBingoTable() {
    }

    public UserBingoTable(String id, String userId, String gameSetId, List<Cell> cellList, Boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.gameSetId = gameSetId;
        this.cellList = cellList;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameSetId() {
        return gameSetId;
    }

    public void setGameSetId(String gameSetId) {
        this.gameSetId = gameSetId;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
