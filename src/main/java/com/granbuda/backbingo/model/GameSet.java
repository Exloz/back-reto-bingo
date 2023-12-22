package com.granbuda.backbingo.model;

import java.util.List;

public class GameSet {
    private String id;
    private List<Integer> ballots;
    private List<String> userIds;

    public GameSet(String id, List<Integer> ballots, List<String> userIds) {
        this.id = id;
        this.ballots = ballots;
        this.userIds = userIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getBallots() {
        return ballots;
    }

    public void setBallots(List<Integer> ballots) {
        this.ballots = ballots;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
