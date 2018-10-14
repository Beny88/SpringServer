package com.tomson.service;

import com.tomson.dto.CreateUserDto;
import com.tomson.dto.UpdateUserDto;
import com.tomson.model.Address;
import com.tomson.model.User;
import com.tomson.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(final Long userId) {
        return userRepository.findOne(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(final CreateUserDto createUserDto){
        final User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(final Long userId){
        userRepository.delete(userId);
    }

    @Transactional
    public User updateUser(final UpdateUserDto updateUserDto) {
        User userInDb = userRepository.findOne(updateUserDto.getId());

        if(userInDb != null) {
            userInDb.setFirstName(updateUserDto.getFirstName());
            userInDb.setLastName(updateUserDto.getLastName());
            userInDb.setPhone(updateUserDto.getPhone());
            userInDb.setEmail(updateUserDto.getEmail());
            return userInDb;
        } else {
            throw new NullPointerException();
        }
    }

    public List<Address> getAddressForUser(Long userId) {
        return userRepository.findOne(userId).getAddressList();
    }
}
