package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.User;
import com.testask.shortenerURL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }
}
