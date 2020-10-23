package ru.arsakhanov.exam.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.arsakhanov.exam.entity.User;
import ru.arsakhanov.exam.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/exam/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = {"{id}"})
    @PreAuthorize("hasAuthority('users:read')")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
}
