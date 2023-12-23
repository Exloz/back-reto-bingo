package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.HomeWebSocketDTO;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class HomeWebSocketController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public HomeWebSocketDTO chat(@DestinationVariable String roomId, HomeWebSocketDTO homeWebSocketDTO) {
        return new HomeWebSocketDTO(homeWebSocketDTO.getMessage(), homeWebSocketDTO.getUser());
    }
}
