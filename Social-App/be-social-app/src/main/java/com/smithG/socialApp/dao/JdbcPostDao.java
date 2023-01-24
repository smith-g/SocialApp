package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Posts;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPostDao implements PostDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
            String sql = "INSERT INTO post(texts, likes, comments_id, user_id)" +
                    " VALUES(?,?,?,?)";
            String getPost = "Select * from post where post_id = ?";
            Posts posts1 = new Posts();

            jdbcTemplate.queryForRowSet(sql, posts.getTexts(), posts.getLikes(),
                    posts.getComments_id(), posts.getUser_id());
            SqlRowSet rs = jdbcTemplate.queryForRowSet(getPost, posts.getPost_id());
             while (rs.next()){
                 posts1 = mapRowToPost(rs);
             }
             return posts1;
    }

    @Override
    public void deletePost(Long postId) {

    }

    private Posts mapRowToPost(SqlRowSet rs){
        Posts posts = new Posts();
        posts.setPost_id(rs.getLong("post_id"));
        posts.setTexts(rs.getNString("texts"));
        posts.setLikes(rs.getInt("likes"));
        posts.setComments_id(rs.getLong("comment_id"));
        posts.setUser_id(rs.getLong("user_id"));
        return posts;
    }

}
