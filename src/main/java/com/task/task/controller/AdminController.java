package com.task.task.controller;

import com.task.task.model.User;
import com.task.task.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/admin/updateFeedback")
    public String updateFeedback(@RequestParam String username, @RequestParam String feedback) {
        userService.updateFeedback(username, feedback);
        return "redirect:/admin?success=updated";
    }

    @PostMapping("/admin/deleteFeedback")
    public String deleteFeedback(@RequestParam String username) {
        userService.updateFeedback(username, null);
        return "redirect:/admin?success=deleted";
    }
}
