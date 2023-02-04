package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Posts;

import java.util.List;

public interface PostDao {

    List<Posts> getAllPosts();

    Posts findPostById(Long postId);

    List<Posts> findPostsByUserId(Long userId);

    Posts addPost(Posts posts);

    void deletePost(Long postId);

    void addLikes(long postId, long userId);

}
