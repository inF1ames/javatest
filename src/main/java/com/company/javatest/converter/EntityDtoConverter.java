package com.company.javatest.converter;

import com.company.javatest.dao.entity.Holiday;
import com.company.javatest.dao.entity.User;
import com.company.javatest.model.dto.HolidayDto;
import com.company.javatest.model.dto.UserDto;

public final class EntityDtoConverter {

    private EntityDtoConverter() {}

    public static User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

    public static UserDto convert(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public static HolidayDto convert(Holiday holiday) {
        if (holiday == null) {
            return null;
        }

        HolidayDto holidayDto = new HolidayDto();
        holidayDto.setId(holiday.getId());
        holidayDto.setName(holiday.getName());
        holidayDto.setDay(holiday.getDay());
        holidayDto.setMonth(holiday.getMonth());
        return holidayDto;
    }

    public static Holiday convert(HolidayDto holidayDto) {
        if (holidayDto == null) {
            return null;
        }

        Holiday holiday = new Holiday();
        holiday.setId(holidayDto.getId());
        holiday.setName(holidayDto.getName());
        holiday.setDay(holidayDto.getDay());
        holiday.setMonth(holidayDto.getMonth());
        return holiday;
    }
}
