package com.granbuda.backbingo.model.dto;

import com.granbuda.backbingo.model.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BingoTableResponse {
    private List<Cell> cellList;
    private Boolean isActive;

}
