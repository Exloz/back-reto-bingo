package com.granbuda.backbingo.model.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse {
    private List<String> userList;

    public UserListResponse() {
        userList = new ArrayList<>();
    }

    public UserListResponse(List<String> userList) {
        this.userList = userList;
    }

    public void addUser(String userName){
        userList.add(userName);
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserListResponse{" +
                "userList=" + userList +
                '}';
    }
}
