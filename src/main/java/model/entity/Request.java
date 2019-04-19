package model.entity;

import model.entity.enums.State;

import java.sql.Date;

public class Request {

    private int id;
    private String content;
    private Date date;
    private State accepted;
    private String comment;

    public int getId() {
        return id;
    }

    public Request(int id, State accepted) {
        this.id = id;
        this.accepted = accepted;
    }

    public Request(int id, State accepted, String comment) {
        this.id = id;
        this.accepted = accepted;
        this.comment = comment;
    }

    public Request() {
    }

    public Request(String content, Date date, State accepted, String comment) {
        this.content = content;
        this.date = date;
        this.accepted = accepted;
        this.comment = comment;
    }

    public Request(int id, String content, Date date, State accepted, String comment) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.accepted = accepted;
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public State getAccepted() {
        return accepted;
    }

    public void setAccepted(State accepted) {
        this.accepted = accepted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
