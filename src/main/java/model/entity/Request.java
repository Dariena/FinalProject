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
