package com.company.javatest.model;

import com.company.javatest.dao.HolidayDao;
import com.company.javatest.model.dto.HolidayDto;
import com.company.javatest.model.filter.HolidayFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class WeekendCounter {

    @Autowired
    private HolidayDao holidayDao;


    public int getAmountOfWeekends(Date start, Date end) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);

        HolidayFilter filter = createFilter(startDate, endDate);
        List<HolidayDto> holidays = holidayDao.findByFilter(filter);
        int weekends = 0;

        for (; startDate.getTime().getTime() <= endDate.getTime().getTime(); startDate.add(Calendar.DAY_OF_YEAR, 1)) {
            if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                weekends++;
            }
            for (HolidayDto holiday : holidays) {
                if (startDate.get(Calendar.DAY_OF_MONTH) == holiday.getDay()) {
                    if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                            startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                        weekends++;
                    }
                }
            }
        }
        return weekends;
    }

    private HolidayFilter createFilter(Calendar startDate, Calendar endDate) {
        HolidayFilter filter = new HolidayFilter();
        filter.setDayFrom(startDate.get(Calendar.DAY_OF_MONTH));
        filter.setDayTo(endDate.get(Calendar.DAY_OF_MONTH));
        filter.setMonthFrom(startDate.get(Calendar.MONTH));
        filter.setMonthTo(endDate.get(Calendar.MONTH));

        return filter;
    }
}

