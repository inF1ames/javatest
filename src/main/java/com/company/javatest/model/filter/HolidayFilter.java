package com.company.javatest.model.filter;

public class HolidayFilter {

    private Integer dayFrom;
    private Integer dayTo;
    private Integer MonthFrom;
    private Integer MonthTo;

    public Integer getDayFrom() {
        return dayFrom;
    }

    public void setDayFrom(Integer dayFrom) {
        this.dayFrom = dayFrom;
    }

    public Integer getDayTo() {
        return dayTo;
    }

    public void setDayTo(Integer dayTo) {
        this.dayTo = dayTo;
    }

    public Integer getMonthFrom() {
        return MonthFrom;
    }

    public void setMonthFrom(Integer monthFrom) {
        MonthFrom = monthFrom;
    }

    public Integer getMonthTo() {
        return MonthTo;
    }

    public void setMonthTo(Integer monthTo) {
        MonthTo = monthTo;
    }

    @Override
    public String toString() {
        return "HolidayFilter{" +
                "dayFrom=" + dayFrom +
                ", dayTo=" + dayTo +
                ", MonthFrom=" + MonthFrom +
                ", MonthTo=" + MonthTo +
                '}';
    }
}
