package ru.arsakhanov.exam.service;

import org.springframework.stereotype.Service;
import ru.arsakhanov.exam.entity.User;
import ru.arsakhanov.exam.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
