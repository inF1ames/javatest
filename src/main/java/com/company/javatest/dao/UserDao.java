package com.company.javatest.dao;

import com.company.javatest.model.dto.UserDto;

public interface UserDao {

    void add(UserDto userDto);
    UserDto findByUsername(String username);
}
