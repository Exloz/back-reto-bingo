package com.granbuda.backbingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BingoBallotsResponse {
    private List<Integer> ballots;
}
