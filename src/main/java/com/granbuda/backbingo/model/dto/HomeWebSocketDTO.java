package com.granbuda.backbingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeWebSocketDTO {
    private String content;
    private String sender;
    private MessageType type;
}
