package model.entity;


import java.sql.Date;

public class Review {
    private int id;
    private Date date;
    private String content;
    private String email;

    public Review(int id, Date date, String content, String email) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.email = email;
    }

    public Review(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
