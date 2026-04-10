package com.task.task.service;

import com.task.task.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("admin", "admin@domain.com", "admin"));
    }

        public void register(User user) {
            users.add(user);
        }

        public boolean login(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) &&
                        user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }

        public User findByUsername(String username) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }

        public void updateFeedback(String username, String feedback) {
            User user = findByUsername(username);
            if (user != null) {
                user.setFeedback(feedback);
            }
        }

        public List<User> getAllUsers() {
            return users;
        }

}
