package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.model.dto.BingoOneBallotResponse;
import com.granbuda.backbingo.model.dto.MessageType;
import com.granbuda.backbingo.repository.GameSetRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameWebSocketService {
    private final GameSetRepository repository;
    private final SimpMessagingTemplate messagingTemplate;
    private final Set<Integer> generatedNumbers = new HashSet<>();
    private final Random random = new Random();
    private Timer timer;
    private Boolean isActiveGame;
    List<Integer> ballots = new ArrayList<>();

    public GameWebSocketService(GameSetRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    public void startGeneratingBallots() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                generateUniqueBallot();
            }
        }, 0, 5000);
    }

    private void generateUniqueBallot() {
        GameSet activeGameSet = repository.findByIsActiveGameTrue();
        isActiveGame = activeGameSet.getActiveGame();

        if (generatedNumbers.size() >= 75) {
            stopGeneratingNumbers();
            return;
        }

        int number;
        do {
            number = random.nextInt(75) + 1;
        } while (generatedNumbers.contains(number));

        ballots.add(number);
        System.out.println(ballots);
        activeGameSet.setBallots(ballots);
        generatedNumbers.add(number);
        repository.save(activeGameSet);

        BingoOneBallotResponse responseMessage = new BingoOneBallotResponse();
        responseMessage.setType(MessageType.BALLOT);
        responseMessage.setContent(number);
        messagingTemplate.convertAndSend("/topic/public", responseMessage);
    }

    public void stopGeneratingNumbers() {
        if (timer != null || !isActiveGame) {
            timer.cancel();
            timer = null;
            generatedNumbers.clear();
            ballots.clear();
        }
    }
}
