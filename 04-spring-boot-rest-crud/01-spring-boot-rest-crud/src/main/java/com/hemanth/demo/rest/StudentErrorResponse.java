package com.hemanth.demo.rest;

public class StudentErrorResponse {

    private int status;

    private String message;

    private Long curTimeStamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCurTimeStamp() {
        return curTimeStamp;
    }

    public void setCurTimeStamp(Long curTimeStamp) {
        this.curTimeStamp = curTimeStamp;
    }

    public StudentErrorResponse(int status, String message, Long curTimeStamp) {
        this.status = status;
        this.message = message;
        this.curTimeStamp = curTimeStamp;
    }

    public StudentErrorResponse() {
    }
}
