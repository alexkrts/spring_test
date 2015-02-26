package com.alex.spring.dao.impl;

import org.hibernate.SessionFactory;

import javax.annotation.Resource;

public abstract class HibernateDao {

    private SessionFactory sessionFactory;

    public Object save(Object obj){
        sessionFactory.getCurrentSession().saveOrUpdate(obj);
        return obj;
    }

    public void delete(Object obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}