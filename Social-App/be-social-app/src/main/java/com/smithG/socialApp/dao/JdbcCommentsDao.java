package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Comments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCommentsDao implements CommnetsDao{

    @Override
    public Comments findCommentById(Long commentId) {
        return null;
    }

    @Override
    public List<Comments> commentsByPost(Long postId) {
        return null;
    }

    @Override
    public Double likes(Double likes) {
        return null;
    }

    @Override
    public List<Comments> repliesByUser(Long userId) {
        return null;
    }
}
