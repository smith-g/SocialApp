package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Posts> getAllPosts() {
        String sql = "SELECT * FROM post";
        List<Posts> posts = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Posts post = mapRowToPost(results);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Posts findPostById(Long postId) {
        Posts posts = new Posts();
        String sql = "SELECT * FROM post where post_id = ? ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);

        while (results.next()){
            posts = mapRowToPost(results);

        }
        return posts;
    }

    @Override
    public List<Posts> findPostsByUserId(Long userId) {
        List<Posts> posts = new ArrayList<>();
        String sql = "SELECT * FROM post where user_id = ? ORDER BY post_id DESC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()){
            Posts post = mapRowToPost(results);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Posts addPost(Posts posts) {
            String sql = "INSERT INTO post(texts, likes, num_comments, user_id)" +
                    " VALUES(?,?,?,?)";

            jdbcTemplate.queryForRowSet(sql, posts.getTexts(), posts.getLikes(),
                    posts.getNum_Comments(), posts.getUser_id());

             return findPostById(posts.getPost_id());
    }

    @Override
    public void deletePost(Long postId) {
        String sql = "DELETE FROM post WHERE post_id = ?";
        jdbcTemplate.update(sql, postId);
    }

    @Override
    public void addLikes(long postId, long userId) {
        String sql  = "BEGIN TRANSACTION;" +
                "INSERT INTO likes(post_id, user_id) values (?,?)" +
                "UPDATE post SET likes = (SELECT COUNT(*) FROM likes where post_id = ?) where post_id = ?" +
                "COMMIT;";

        jdbcTemplate.update(sql, postId, userId);
    }



    private Posts mapRowToPost(SqlRowSet rs){
        Posts posts = new Posts();
        posts.setPost_id(rs.getLong("post_id"));
        posts.setTexts(rs.getString("texts"));
        posts.setLikes(rs.getInt("likes"));
        posts.setNum_Comments(rs.getInt("num_comments"));
        posts.setUser_id(rs.getLong("user_id"));
        return posts;
    }

}
