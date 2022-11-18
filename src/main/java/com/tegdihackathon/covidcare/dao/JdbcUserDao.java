package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public User createUser(String userName, int userId, String password) {
       return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User>
        return null;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT user_id, username FROM public.care_user WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToUser(results);
        } else {
            return null;
        }

    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public User updateUser(User user, String userName) {
        return null;
    }

    @Override
    public User deleteUser(User user, String username) {
        return null;
    }

    public User mapRowToUser(SqlRowSet result) {
        User user = new User();
        user.setUserId(result.getInt("user_id"));
        user.setUserName(result.getString("username"));
        user.setPassword(result.getString("user_password"));
        return user;
    }
}
