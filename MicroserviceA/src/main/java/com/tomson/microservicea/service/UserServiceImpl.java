package com.tomson.microservicea.service;

import com.tomson.microservicea.dto.CreateAddressDto;
import com.tomson.microservicea.dto.CreateUserDto;
import com.tomson.microservicea.dto.UpdateUserDto;
import com.tomson.microservicea.model.Address;
import com.tomson.microservicea.repository.AddressRepository;
import com.tomson.microservicea.repository.UserRepository;
import com.tomson.microservicea.model.User;
import com.tomson.microservicea.dto.UpdateAddressDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User getUser(final Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NullPointerException("500"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User createUser(final CreateUserDto createUserDto){
        final User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPhone(createUserDto.getPhone());
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(final Long userId){
        userRepository.deleteById(userId);
    }

    @Transactional
    @Override
    public User updateUser(final UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId()).orElseThrow(() -> new NullPointerException());

        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setPhone(updateUserDto.getPhone());
        user.setEmail(updateUserDto.getEmail());
        return user;
    }

    @Transactional
    @Override
    public Address createAddress(final CreateAddressDto createAddressDto, final Long userId) {
        final Address address = new Address();
        final User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException());
        address.setUser(user);
        address.setUlica(createAddressDto.getUlica());
        address.setNrUlicy(createAddressDto.getNrUlicy());
        address.setPostCode(createAddressDto.getPostCode());
        address.setMiasto(createAddressDto.getMiasto());
        return addressRepository.save(address);
    }

    @Transactional
    @Override
    public Address updateAddress(final UpdateAddressDto updateAddressDto, final Long userId) {
        Address address = getOneAddressForUser(userId, updateAddressDto.getId());


        address.setUlica(updateAddressDto.getUlica());
        address.setNrUlicy(updateAddressDto.getNrUlicy());
        address.setPostCode(updateAddressDto.getPostCode());
        address.setMiasto(updateAddressDto.getMiasto());
        return address;
    }
    @Override
    public List<Address> getAddressForUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NullPointerException()).getAddressList();
    }
    @Override
    public Address getOneAddressForUser(Long userId, Long addressId){
        return addressRepository.findOneByIdAndUserId(addressId, userId).orElseThrow(() -> new NullPointerException("Niema takiego adresu dla podanego uzytkownika"));
    }
}