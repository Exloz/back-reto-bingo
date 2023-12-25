package com.granbuda.backbingo.controller;

import com.granbuda.backbingo.model.dto.HomeWebSocketDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class HomeWebSocketController {

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
        //System.out.println(chatMessage);
        headerAccessor.getSessionAttributes().put("userName", chatMessage.getSender());
        return chatMessage;

    }
}
