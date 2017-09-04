package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }
}
