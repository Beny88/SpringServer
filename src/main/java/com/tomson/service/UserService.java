package com.tomson.service;

import com.tomson.dto.CreateAddressDto;
import com.tomson.dto.CreateUserDto;
import com.tomson.dto.UpdateUserDto;
import com.tomson.model.Address;
import com.tomson.model.User;
import com.tomson.repository.AddressRepository;
import com.tomson.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tomson.dto.UpdateAddressDto;
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

    @Transactional
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
    public Address updateAddress(final UpdateAddressDto updateAddressDto, final Long userId) {
        Address address = getOneAddressForUser(userId, updateAddressDto.getId());
//czemu nie dziala znalezienie po sddress id i userid??
        //sprawdzenie po user id jakies security
// adressid should be id in dto

        address.setUlica(updateAddressDto.getUlica());
        address.setNrUlicy(updateAddressDto.getNrUlicy());
        address.setPostCode(updateAddressDto.getPostCode());
        address.setMiasto(updateAddressDto.getMiasto());
        return address;
    }

    public List<Address> getAddressForUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NullPointerException()).getAddressList();
    }

    public Address getOneAddressForUser(Long userId, Long addressId){
        return addressRepository.findOneByIdAndUserId(addressId, userId).orElseThrow(() -> new NullPointerException("Niema takiego adresu dla podanego uzytkownika"));
    }
}