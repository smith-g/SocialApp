package com.smithG.socialApp.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "post_id")
    private Long post_id;
    private String texts;
    private int likes;
    private int num_Comments;
    private Long user_id;



    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getNum_Comments() {
        return num_Comments;
    }

    public void setNum_Comments(int num_Comments) {
        this.num_Comments = num_Comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
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
                ", texts='" + texts + '\'' +
                ", likes=" + likes +
                ", Comments_id=" + num_Comments +
                ", user_id=" + user_id +
                '}';
    }
}
