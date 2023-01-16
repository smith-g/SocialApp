package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Posts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPostDao implements PostDao{

    @Override
    public Posts findPostById(Long postId) {
        return null;
    }

    @Override
    public List<Posts> findPostByUserId(Long userId) {
        return null;
    }

    @Override
    public Posts addPost(Posts posts) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }
}
