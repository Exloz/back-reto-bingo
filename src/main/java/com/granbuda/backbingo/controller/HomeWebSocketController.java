package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.BingoBallotsResponse;
import com.granbuda.backbingo.model.dto.BingoOneBallotResponse;
import com.granbuda.backbingo.model.dto.HomeWebSocketDTO;
import com.granbuda.backbingo.service.GameWebSocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class HomeWebSocketController {

    private final GameWebSocketService service;

    public HomeWebSocketController(GameWebSocketService service) {
        this.service = service;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public HomeWebSocketDTO sendMessage(@Payload HomeWebSocketDTO chatMessage) {
        //System.out.println(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public HomeWebSocketDTO addUser(@Payload HomeWebSocketDTO chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());
        return chatMessage;

    }

    @MessageMapping("/chat.startGame")
    @SendTo("/topic/public")
    public HomeWebSocketDTO startGame(@Payload HomeWebSocketDTO chatMessage,
                                    SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());
        return chatMessage;

    }

    @MessageMapping("/chat.generateBallot")
    @SendTo("/topic/public")
    public void generateBallot(@Payload HomeWebSocketDTO chatMessage,
                                                 SimpMessageHeaderAccessor headerAccessor) {
        service.startGeneratingBallots();
        headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());

    }


}
