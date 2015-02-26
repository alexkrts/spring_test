package com.alex.spring.controllers;

import com.alex.spring.dto.UserDto;
import com.alex.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 2/25/2015.
 */

@RestController
public class UserController {

    private static final String USERS = "/users";
    private static final String USER = USERS + "/{userId}";
    private static final String CURRENT_USERS = USERS + "/current";

    @Autowired
    UserService service;
//localhost:port/users/3
    @RequestMapping(value = USERS, method = RequestMethod.GET)
    public UserDto getCurrentUser(@PathVariable Long id) {
        return service.getUser(id);
    }

}
