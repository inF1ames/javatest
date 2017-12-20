package com.company.javatest.model.dto;

public class HolidayDto {

    private Long id;
    private String name;
    private Integer day;
    private Integer month;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayDto that = (HolidayDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        return month != null ? month.equals(that.month) : that.month == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HolidayDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                '}';
    }
}
