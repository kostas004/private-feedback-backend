package com.pfa.privatefeedbackapp.service;

import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    //public User getUserByEmail(String email) { return userRepository.findByEmail(email); }
    public User getUserByUsername(String userName) { return userRepository.findByUsername(userName); }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}