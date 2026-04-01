package com.example.spring_boot_app.dto;


import java.io.Serializable;
import java.util.Date;

public class ArticleDTO implements Serializable {

    private Long id;

    private Long userId;

    private String title;

    private String body;

    private Date createdDate;

    private Date updatedDate;

    public ArticleDTO() {
    }

    public ArticleDTO(Long id, Long userId, String title, String body, Date createdDate, Date updatedDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
