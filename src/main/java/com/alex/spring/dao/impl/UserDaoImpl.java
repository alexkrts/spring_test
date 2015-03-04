package com.alex.spring.dao.impl;

import com.alex.spring.dao.UserDao;
import com.alex.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2/25/2015.
 */
@Repository
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
        return returnUserListTest();
    }

    @Override
    public User update(User user) {
        return (User)super.save(user);
    }

    @Override
    public void remove(User user) {
        super.delete(user);
    }

    private List<User> returnUserListTest(){
        ArrayList<User> testList = new ArrayList<User>();
        testList.add(new User(1L, "firstName1", "secondName1", "Domain1"));
        testList.add(new User(1L, "firstName2", "secondName2", "Domain2"));

        return testList;
    }
}
