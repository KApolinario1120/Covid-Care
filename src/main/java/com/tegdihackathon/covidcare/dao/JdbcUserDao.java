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
    public boolean createUser(String username, String password) {

        // create user
        String sql = "INSERT INTO public.care_user (username, password) VALUES (?, ?) RETURNING user_id";
        Integer newUserId = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

        if (newUserId == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username FROM care_user;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUserWithoutPassword(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT user_id, username FROM public.care_user WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToUserWithoutPassword(results);
        } else {
            return null;
        }
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("SELECT user_id FROM public.care_user WHERE username = ?", int.class, username);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new RuntimeException("User " + username + " was not found");
        }
        return userId;
    }

    @Override
    public User updateUser(User user, String username) {
        return null;
    }

    @Override
    public User deleteUser(User user, String username) {
        return null;
    }

    public User mapRowToUserWithoutPassword(SqlRowSet result) {
        User user = new User();
        user.setUserId(result.getInt("user_id"));
        user.setUsername(result.getString("username"));
        return user;
    }
}
