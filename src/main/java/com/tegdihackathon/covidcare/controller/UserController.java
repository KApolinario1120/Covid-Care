package com.tegdihackathon.covidcare.controller;

import com.tegdihackathon.covidcare.dao.UserDao;
import com.tegdihackathon.covidcare.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {

    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(path = "/userId/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        } else {
            return user;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody User newUser) {
        if (!userDao.createUser(newUser.getUserName(), newUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
        }
    }

//
//    //get a user ID by username
//    User findIdByUserName(String userName);
//
//    //Update a user
//    User updateUser(User user, String userName);
//
//    //Delete a user
//    User deleteUser(User user, String username);


//    @RequestMapping (path = "/{userName}", method = RequestMethod.GET)
//    public User findUserByUserName(String userName) {
//        User user = userDao.findIdByUserName(userName);
//        if (user == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
//        } else {
//            return user;
//        }
//    }
    }


