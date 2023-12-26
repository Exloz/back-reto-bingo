package com.granbuda.backbingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketWinnerController {

    @Autowired
    private SimpMessagingTemplate template;

    public void notifyLoss() {
        template.convertAndSend("/topic/loss", "Has perdido, alguien más ganó.");
    }
}