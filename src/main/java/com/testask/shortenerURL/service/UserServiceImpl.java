package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.User;
import com.testask.shortenerURL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.getUser(userName);
    }
}
