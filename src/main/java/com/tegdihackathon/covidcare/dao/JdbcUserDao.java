package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public boolean createUser(String userName, String password) {

        // create user
        String sql = "INSERT INTO public.care_user (username, password) VALUES (?, ?) RETURNING user_id";
        Integer newUserId = jdbcTemplate.queryForObject(sql, Integer.class, userName, password);

        if (newUserId == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username FROM public.care_user";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
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
    public int findIdByUserName(String userName) {
        if (userName == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("SELECT user_id FROM public.care_user WHERE username = ?", int.class, userName);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new RuntimeException("User " + userName + " was not found");
        }

        return userId;
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
