package com.granbuda.backbingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketWinnerController {


    private final SimpMessagingTemplate template;

    public WebSocketWinnerController(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void notifyLoss() {
        template.convertAndSend("/topic/loss", "Has perdido, alguien más ganó.");
    }

    @PostMapping("/api/v1/notify/win")
    public ResponseEntity<?> notifyWin(@RequestBody String winningUser) {
        template.convertAndSend("/topic/loss", "Alguien ha ganado");
        return ResponseEntity.ok().build();
    }
}