package com.granbuda.backbingo.config;

import com.granbuda.backbingo.model.dto.HomeWebSocketDTO;
import com.granbuda.backbingo.model.dto.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class HomeWebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleHomeWebSocketConnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("userName");
        if(username != null){
            var chatMessage = HomeWebSocketDTO.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messageTemplate.convertAndSend("/topic/public", chatMessage);

        }
    };
}
