package com.granbuda.backbingo.model.dto;

import com.granbuda.backbingo.model.Cell;

import java.util.List;

public class UserResponse {
    private String id;
    private String name;
    private List<Cell> cellList;

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

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }
}
