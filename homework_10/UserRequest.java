package com.proftelran.org.homework_10;

public class UserRequest {
    private String address;
    private Answer answer;

    public UserRequest(String address, Answer answer) {
        this.address = address;
        this.answer = answer;
    }

    public String getAddress() {
        return address;
    }

    public Answer getAnswer() {
        return answer;
    }
}
