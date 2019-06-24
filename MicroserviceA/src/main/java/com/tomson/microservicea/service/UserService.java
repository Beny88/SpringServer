package com.tomson.microservicea.service;

import com.tomson.microservicea.dto.CreateAddressDto;
import com.tomson.microservicea.dto.CreateUserDto;
import com.tomson.microservicea.dto.UpdateAddressDto;
import com.tomson.microservicea.dto.UpdateUserDto;
import com.tomson.microservicea.model.Address;
import com.tomson.microservicea.model.User;

import java.util.List;

public interface UserService {

    User getUser(final Long userId);

    List<User> getUsers();

    User createUser(final CreateUserDto createUserDto);

    void deleteUser(final Long userId);

    User updateUser(final UpdateUserDto updateUserDto);

    Address createAddress(final CreateAddressDto createAddressDto, final Long userId);

    Address updateAddress(final UpdateAddressDto updateAddressDto, final Long userId);

    List<Address> getAddressForUser(Long userId);

    Address getOneAddressForUser(Long userId, Long addressId);
}
