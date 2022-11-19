package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.UserDao;
import com.tegdihackathon.covidcare.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("")
public class UserController {

    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "user", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(path = "user/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody User newUser) {
        if (!userDao.createUser(newUser.getUsername(), newUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
        }
    }

    @RequestMapping(path = "user/userId/{username}", method = RequestMethod.GET)
    public int findIdByUsername(String username) {return userDao.findIdByUsername(username);
    }

}


