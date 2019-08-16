package com.examplespringboot.demo.Entity;

public class ErrorModel {

    private boolean Status;
    private String message;

    public ErrorModel(boolean status, String message) {
        Status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
