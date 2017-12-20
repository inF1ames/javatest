package com.company.javatest.dao;

import com.company.javatest.model.dto.HolidayDto;
import com.company.javatest.model.filter.HolidayFilter;

import java.util.List;

public interface HolidayDao {

    void add(HolidayDto holidayDto);
    HolidayDto getByName(String name);
    List<HolidayDto> findByFilter(HolidayFilter filter);
    void update(HolidayDto holidayDto);
    void remove(HolidayDto holidayDto);
}
