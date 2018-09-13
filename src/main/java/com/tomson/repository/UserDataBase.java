package com.tomson.repository;

import com.tomson.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataBase {

    private List<User> userList = new ArrayList<>();

    public User findByUserId(Long userId) {
        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId() == userId) {
                return userList.get(i);
            }
        }

        return null;
    }
}

