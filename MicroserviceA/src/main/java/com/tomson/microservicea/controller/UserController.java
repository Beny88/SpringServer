package com.tomson.microservicea.controller;

import com.tomson.microservicea.dto.CreateAddressDto;
import com.tomson.microservicea.dto.CreateUserDto;
import com.tomson.microservicea.dto.UpdateAddressDto;
import com.tomson.microservicea.dto.UpdateUserDto;
import com.tomson.microservicea.model.Address;
import com.tomson.microservicea.model.User;
import com.tomson.microservicea.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable(value = "id") Long userId) {
		return userService.getUser(userId);
	}
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public User createUser(@RequestBody final CreateUserDto user) { return userService.createUser(user); }

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable(value = "id") Long userId) { userService.deleteUser(userId);}

	@PutMapping
	public User editUser(@RequestBody final UpdateUserDto user) {
		return userService.updateUser(user);
	}

	@PostMapping("/{userId/address")
	public Address createAddress(@RequestBody final CreateAddressDto address, @PathVariable Long userId){
		return userService.createAddress(address, userId);
	}

	@GetMapping("/{userId}/address")
	public List<Address> getAddressForUser(@PathVariable(value = "userId") Long userId) {
		return userService.getAddressForUser(userId);
	}

	@GetMapping("/{userId}/address/{addressId}")
	public Address getAddress(@PathVariable Long userId, @PathVariable Long addressId ){
		return userService.getOneAddressForUser(userId,addressId);
	}
	@PutMapping("/{userId}/address")
	public Address updateAddress(@RequestBody final UpdateAddressDto address, @PathVariable Long userId){
		return userService.updateAddress(address, userId);
	}
}
/*
*/