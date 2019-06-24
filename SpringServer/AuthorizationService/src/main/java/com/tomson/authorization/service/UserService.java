package com.tomson.authorization.service;

import com.tomson.authorization.dto.CreateUserDto;
import com.tomson.authorization.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(CreateUserDto createUserDto);

    void deleteUser(Long id);


}
