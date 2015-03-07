package com.alex.spring.service.impl;

import com.alex.spring.dto.UserDto;
import com.alex.spring.model.User;
import com.alex.spring.service.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by alex on 2/25/2015.
 */
@Slf4j
@Service
public class ConverterImpl implements Converter {
    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getFirstName() + "_" + user.getSecondName());
        userDto.setEmail(user.getFirstName().toLowerCase() + "_" + user.getSecondName().toLowerCase() + "@" + user.getCompanyDomain());
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(parseFirstName(userDto));
        user.setSecondName(parseSecondName(userDto));
        user.setCompanyDomain(parseCompanyDomain(userDto));
        return user;
    }

    private String parseFirstName(UserDto userDto) {
        return userDto.getUsername().substring(0, userDto.getUsername().indexOf("_"));
    }

    private String parseSecondName(UserDto userDto) {
        return userDto.getUsername().substring(userDto.getUsername().indexOf("_"), userDto.getUsername().length() - 1);
    }

    private String parseCompanyDomain(UserDto userDto) {
        return userDto.getEmail().substring(userDto.getEmail().indexOf('@') + 1, userDto.getEmail().length() - 1);
    }
}
