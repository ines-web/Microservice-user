package com.Groupe5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "users";

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        kafkaTemplate.send(TOPIC, "User created: " + savedUser.getName());
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}