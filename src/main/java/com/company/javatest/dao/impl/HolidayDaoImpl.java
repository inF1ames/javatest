package com.company.javatest.dao.impl;

import com.company.javatest.converter.EntityDtoConverter;
import com.company.javatest.dao.HolidayDao;
import com.company.javatest.dao.entity.Holiday;
import com.company.javatest.model.dto.HolidayDto;
import com.company.javatest.model.filter.HolidayFilter;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class HolidayDaoImpl implements HolidayDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(HolidayDto holidayDto) {
        sessionFactory.getCurrentSession().save(EntityDtoConverter.convert(holidayDto));
    }

    @Override
    public HolidayDto getByName(String name) {
        return (HolidayDto) sessionFactory.getCurrentSession()
                .createQuery("select h from Holiday h where h.name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    @Override
    public List<HolidayDto> findByFilter(HolidayFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Holiday.class);
        if (filter.getDayFrom() != null) {
            criteria.add(Restrictions.ge("day", filter.getDayFrom()));
        }
        if (filter.getDayTo() != null) {
            criteria.add(Restrictions.le("day", filter.getDayTo()));
        }
        if (filter.getMonthFrom() != null) {
            criteria.add(Restrictions.ge("month", filter.getMonthFrom()));
        }
        if (filter.getMonthTo() != null) {
            criteria.add(Restrictions.le("month", filter.getMonthTo()));
        }
        List<Holiday> holidays = criteria.list();
        return holidays.stream().map(EntityDtoConverter::convert).collect(Collectors.toList());
    }

    @Override
    public void update(HolidayDto holidayDto) {
        sessionFactory.getCurrentSession().update(EntityDtoConverter.convert(holidayDto));
    }

    @Override
    public void remove(HolidayDto holidayDto) {
        sessionFactory.getCurrentSession().delete(EntityDtoConverter.convert(holidayDto));
    }
}
