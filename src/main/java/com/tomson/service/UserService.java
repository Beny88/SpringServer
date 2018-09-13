package com.tomson.service;

import com.tomson.model.User;
import com.tomson.repository.UserDataBase;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDataBase userDataBase;

    public UserService(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    public User getUser(final Long userId) {
        return userDataBase.findByUserId(userId);
    }
}
