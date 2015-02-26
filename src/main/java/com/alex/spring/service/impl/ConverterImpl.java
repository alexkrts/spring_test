package com.alex.spring.service.impl;

import com.alex.spring.dto.UserDto;
import com.alex.spring.model.User;
import com.alex.spring.service.Converter;

/**
 * Created by alex on 2/25/2015.
 */
public class ConverterImpl implements Converter {
    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getFirstName() + "_" + user.getSecondName());
        // better to do it with string pattern (template)
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
        return null;
    }

    private String parseFirstName(UserDto userDto) {
        return null; // TODO: parse first part of username Firstname_Secondname
    }

    private String parseSecondName(UserDto userDto) {
        return null; // TODO: parse second part of username Firstname_Secondname
    }

    private String parseCompanyDomain(UserDto userDto) {
        return null; // TODO: parse text after '@' symbol firstname_secondname@domain.com
    }
}
