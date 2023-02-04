package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Comments;

import java.util.List;

public interface CommnetsDao {

    Comments findCommentById(Long commentId);

    List<Comments> commentsByPost(Long postId);

    List<Comments> repliesByUser(Long userId);

    Comments addComment(Comments comments);

    void addLikes(long commentsId, long userId);

    void deleteComments(long commentsId);
}
