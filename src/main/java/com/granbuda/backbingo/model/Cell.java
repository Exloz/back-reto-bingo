package com.granbuda.backbingo.model;

public class Cell {
    private String userBingoId;
    private Integer number;
    private Integer coordinate;

    public Cell(String userBingoId, Integer number, Integer coordinate) {
        this.userBingoId = userBingoId;
        this.number = number;
        this.coordinate = coordinate;
    }

    public String getUserBingoId() {
        return userBingoId;
    }

    public void setUserBingoId(String userBingoId) {
        this.userBingoId = userBingoId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }
}
