package com.granbuda.backbingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BingoOneBallotResponse {
    private Integer content;
    private MessageType type;
}

