package com.example.mad_mini_project.model;

public class NotificationData {
    String message;
    String title;

    public NotificationData(String title,String message) {

        this.message = message;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
