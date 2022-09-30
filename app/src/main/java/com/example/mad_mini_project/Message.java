package com.example.mad_mini_project;

public class Message {
    String Date;
    String Time;
    String msg;


    public Message(String Date,String Time,String msg) {
        this.Date = Date;
        this.Time = Time;
        this.msg = msg;

    }

    public String getMessage() {
        return msg;
    }
    public String getDate() {
        return Date;
    }
    public String getTime() {
        return Time;
    }


}
