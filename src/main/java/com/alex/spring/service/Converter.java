package com.alex.spring.service;

import com.alex.spring.dto.UserDto;
import com.alex.spring.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by alex on 2/25/2015.
 */

public interface Converter {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);

}
