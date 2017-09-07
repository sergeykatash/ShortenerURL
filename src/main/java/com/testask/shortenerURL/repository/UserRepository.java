package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.User;

/**
 * Repository for {@link com.testask.shortenerURL.domain.User}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface UserRepository {
    void addUser(User user);
    User findByUserName(String username);
    User getUser(String userName);
}
