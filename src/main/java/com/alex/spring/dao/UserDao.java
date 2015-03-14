package com.alex.spring.dao;

import com.alex.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */

public interface UserDao {

    User create(User user);
    User find(Long id);
    List<User> findAll();
    User update(User user);
    void delete(User user);

}
