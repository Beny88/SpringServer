package com.tomson.controller;

import com.tomson.dto.CreateUserDto;
import com.tomson.dto.UpdateUserDto;
import com.tomson.model.Address;
import com.tomson.model.User;
import com.tomson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

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

	@GetMapping("/{userId}/address")
	public List<Address> getAddressForUser(@PathVariable(value = "userId") Long userId) {
		return userService.getAddressForUser(userId);
	}

	@GetMapping("/{userId}/address/{addressId}")
	public Address getAddress(@PathVariable Long userId, @PathVariable Long addressId ){
		return userService.getOneAddressForUser(userId,addressId);
	}
}
































/*
	@GetMapping(value = "/hello")
	public String getHello() {
		return "<b>Hello World</b>";
	}


	@PostMapping()
	public User createUser(@RequestBody User user) {

		user.setId(123123L);
		//uzytkownikList.add(user);

		return user;
	}

	@GetMapping()
	public List<User> getUserList() {
		return null; //uzytkownikList;
	}
 */