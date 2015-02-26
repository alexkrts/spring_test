package com.alex.spring.dao.impl;

import com.alex.spring.dao.UserDao;
import com.alex.spring.model.User;

import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */
public class UserDaoImpl extends HibernateDao implements UserDao {
    @Override
    public User create(User user) {
        return (User)super.save(user);
    }

    @Override
    public User find(Long id) {
        return (User)getSessionFactory().getCurrentSession().createQuery("select distinct u from User u left join fetch u.visibleProjects p where u.id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return (User)super.save(user);
    }

    @Override
    public void remove(User user) {
        super.delete(user);
    }
}
