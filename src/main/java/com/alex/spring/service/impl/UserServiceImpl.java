package com.alex.spring.service.impl;

import com.alex.spring.dao.UserDao;
import com.alex.spring.dao.impl.UserDaoImpl;
import com.alex.spring.dto.UserDto;
import com.alex.spring.model.User;
import com.alex.spring.service.Converter;
import com.alex.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Converter converter;

    @Override
    public void setUser(UserDto userDto) {
        User user = converter.toEntity(userDto);
        if(user.getId() == null) {
            userDao.create(user);
        } else {
            userDao.update(user);
        }
    }

    @Override
    public UserDto getUser(long id) {
        return converter.toDto(userDao.find(id));
    }

    @Override
    public void removeUser(long id) {
        User user = userDao.find(id);
        userDao.remove(user);
    }

    @Override
    public List<User> fingAll() {
        return userDao.findAll();
    }


}
