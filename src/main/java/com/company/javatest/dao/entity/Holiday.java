package com.company.javatest.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "HOLIDAYS")
public class Holiday {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    @Column(name = "DAY", nullable = false)
    private Integer day;
    @Column(name = "MONTH", nullable = false)
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
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                '}';
    }
}
