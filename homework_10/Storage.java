package com.proftelran.org.homework_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private Map<String, List<UserRequest>> userRequests;

    public Storage() {
        this.userRequests = new HashMap<>();
    }

    public void addRequest(String username, String address, Answer answer) {
        UserRequest userRequest = new UserRequest(address, answer);
        userRequests.computeIfAbsent(username, k -> new ArrayList<>()).add(userRequest);
    }

    public List<UserRequest> getUserRequests(String username) {
        return userRequests.getOrDefault(username, new ArrayList<>());
    }
}
