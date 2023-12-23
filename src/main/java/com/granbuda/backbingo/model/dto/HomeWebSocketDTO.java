package com.granbuda.backbingo.model.dto;

public class HomeWebSocketDTO {
    private String message;
    private String user;

    public HomeWebSocketDTO() {
    }
    public HomeWebSocketDTO(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
