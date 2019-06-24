package com.tomson.authorization.controller;

import com.tomson.authorization.dto.CreateUserDto;
import com.tomson.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody final CreateUserDto user){
        userService.createUser(user);
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return "success";
    }

}