package com.testask.shortenerURL.repository;


import com.testask.shortenerURL.domain.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link UserRepository} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findByUserName(String username) {
       return null;
    }

    @Override
    public User getUser(String userName) {
        Criteria cr = this.sessionFactory.getCurrentSession()
                .createCriteria(User.class, "users")
                .add(Restrictions.eq("userName", userName));
        return (User) cr.uniqueResult();
    }
}
