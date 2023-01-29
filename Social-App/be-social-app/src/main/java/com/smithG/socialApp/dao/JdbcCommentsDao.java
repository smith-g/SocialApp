package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentsDao implements CommnetsDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCommentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comments findCommentById(Long commentId) {
        String sql = "SELECT * FROM comments where comments_id = ?";
        Comments comments = new Comments();

        SqlRowSet results  = jdbcTemplate.queryForRowSet(sql, commentId);
        while (results.next()) {
            comments = mapRowToComments(results);
        }

        return comments;
    }

    @Override
    public List<Comments> commentsByPost(Long postId) {
        String sql = "SELECT * FROM comments where post_id = ? ORDER BY comments_id ASC";
        List<Comments> comments = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);

        while (results.next()){
            Comments comment = mapRowToComments(results);
            comments.add(comment);
        }
        return comments;
    }

    @Override
    public List<Comments> repliesByUser(Long userId) {
        return null;
    }


    private Comments mapRowToComments(SqlRowSet rs){
        Comments comments = new Comments();
        comments.setCommentsId(rs.getLong("comments_id"));
        comments.setText(rs.getNString("text"));
        comments.setLikes(rs.getInt("likes"));
        comments.setPostId(rs.getLong("post_id"));
        comments.setUserId(rs.getLong("user_id"));
        return comments;
    }

}
