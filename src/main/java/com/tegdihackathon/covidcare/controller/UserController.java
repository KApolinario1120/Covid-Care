package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.UserDao;
import com.tegdihackathon.covidcare.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {

    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> ListAllUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public int getIdByUserName(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user.getUserId();
        }
    }
    @RequestMapping (path = "/{userName}", method = RequestMethod.GET)
    public User findUserByUserName(String userName) {
        User user = userDao.findIdByUserName(userName);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }
    }


