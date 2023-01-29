package com.smithG.socialApp.model;

import jakarta.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "comments_id", nullable = false)
    private Long commentsId;
    private String text;
    private Long postId;
    private int likes;
    private Long userId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Long commentsId) {
        this.commentsId = commentsId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentsId=" + commentsId +
                ", text='" + text + '\'' +
                ", postId=" + postId +
                ", likes=" + likes +
                ", userId=" + userId +
                '}';
    }
}
