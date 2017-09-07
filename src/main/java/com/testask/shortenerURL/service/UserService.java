package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.User;

/**
 * Service for {@link com.testask.shortenerURL.domain.User}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface UserService {
    void addUser(User user);
    User getUser(String userName);
}
