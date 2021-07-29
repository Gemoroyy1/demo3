package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/addUser")
    public void addNewUser() {
        userService.addNewUser();
    }

    @GetMapping(value = "/addTheUser")
    public void addNewUser(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "country") String country) {
        userService.addNewUser(id, name, country);
    }

    @GetMapping(value = "/addUsers")
    public void addNewUser(@RequestParam(name = "count") String count) {
        userService.addNewUser(count);
    }

    //Удалить пользователя по ID
    @GetMapping(value = "/deleteUser")
    public void deleteTheUser(@RequestParam(name = "id") String id) {
        userService.deleteTheUser(id);
    }

    //Удалить всех пользователей
    @GetMapping(value = "/deleteUsers")
    public void deleteAllUsers() {
        userService.userRepository.deleteAll();
    }
}
