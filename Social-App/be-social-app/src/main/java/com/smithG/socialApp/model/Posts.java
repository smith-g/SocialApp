package com.smithG.socialApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long post_id;
    private String desc;
    private Timestamp timestamp;
    private int likes;
    private Long Comments_id;
    private Long user_id;



    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getComments_id() {
        return Comments_id;
    }

    public void setComments_id(Long comments_id) {
        Comments_id = comments_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "post_id=" + post_id +
                ", desc='" + desc + '\'' +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", Comments_id=" + Comments_id +
                ", user_id=" + user_id +
                '}';
    }
}
