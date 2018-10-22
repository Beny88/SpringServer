package com.tomson.service;

import com.tomson.dto.CreateUserDto;
import com.tomson.dto.UpdateUserDto;
import com.tomson.model.Address;
import com.tomson.model.User;
import com.tomson.repository.AddressRepository;
import com.tomson.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public User getUser(final Long userId) {
        return userRepository.findById(userId).orElse(null);
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
        userRepository.deleteById(userId);
    }

    @Transactional
    public User updateUser(final UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId()).orElseThrow(() -> new NullPointerException());

        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setPhone(updateUserDto.getPhone());
        user.setEmail(updateUserDto.getEmail());
        return user;
    }

    public List<Address> getAddressForUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NullPointerException()).getAddressList();
    }

    public Address getOneAddressForUser(Long userId, Long addressId){
        return addressRepository.findOneByIdAndUserId(addressId, userId);
    }
}