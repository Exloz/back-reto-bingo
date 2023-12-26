package com.granbuda.backbingo.model;

public class Cell {
    private Integer number;
    private Integer coordinate;

    public Cell() {
    }
    public Cell(Integer number, Integer coordinate) {
        this.number = number;
        this.coordinate = coordinate;
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
