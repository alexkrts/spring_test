package com.alex.spring.service;

import com.alex.spring.dto.UserDto;
import com.alex.spring.model.User;

import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */
public interface UserService {

    void setUser(UserDto user);
    UserDto getUser(long id);
    void removeUser(long id);
    List<UserDto> fingAll();



}
