package com.alex.spring.controllers;

import com.alex.spring.dto.UserDto;
import com.alex.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */

@Slf4j
@RestController
public class UserController {

    private static final String USERS = "/users";
    private static final String USER = USERS + "/{userId}";
    private static final String CURRENT_USERS = USERS + "/current";

    @Autowired
    UserService service;

    @RequestMapping(value = USERS, method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        log.info("Get all users");
        return service.fingAll();
    }

    @RequestMapping(value = USER, method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("userId") Long id) {
        log.info("Get user by id: " + id);
        return service.getUser(id);
    }

    @RequestMapping(value = USERS, method = RequestMethod.POST)
    public void createUser(@RequestBody UserDto userDto) {
        log.info("Create user: " + userDto);
        service.setUser(userDto);
    }

    @RequestMapping(value = USER, method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDto userDto) {
        log.info("Update user: " + userDto);
        service.setUser(userDto);
    }

    @RequestMapping(value = USER, method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Long id) {
        log.info("Delete user by id: " + id);
        service.removeUser(id);
    }

}
