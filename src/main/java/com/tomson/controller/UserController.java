package com.tomson.controller;

import com.tomson.model.User;
import com.tomson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable(value = "id") Long userId) {

		return userService.getUser(userId);
	}

	//Dodaj pobieranie wszytkich uzytkownikow


	//Dodaj towrzenie uzytkownika
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