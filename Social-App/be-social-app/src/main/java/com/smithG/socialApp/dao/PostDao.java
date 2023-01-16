package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Posts;

import java.util.List;

public interface PostDao {

    Posts findPostById(Long postId);

    List<Posts> findPostByUserId(Long userId);

    Posts addPost(Posts posts);

    void deletePost(Long postId);


}
