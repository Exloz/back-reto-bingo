package com.granbuda.backbingo.model;

import java.util.List;


public class BingoTable {

    private List<Cell> cellList;
    private Boolean isActive;

    public BingoTable() {
    }

    public BingoTable(List<Cell> cellList, Boolean isActive) {
        this.cellList = cellList;
        this.isActive = isActive;
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
