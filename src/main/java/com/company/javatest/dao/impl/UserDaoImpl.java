package com.company.javatest.dao.impl;

import com.company.javatest.converter.EntityDtoConverter;
import com.company.javatest.dao.UserDao;
import com.company.javatest.dao.entity.Role;
import com.company.javatest.dao.entity.User;
import com.company.javatest.model.dto.UserDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void add(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userDto.setRole(Role.ROLE_USER);
        sessionFactory.getCurrentSession().save(EntityDtoConverter.convert(userDto));
    }

    @Override
    public UserDto findByUsername(String username) {
      User user = (User) sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
        return EntityDtoConverter.convert(user);
    }
}
