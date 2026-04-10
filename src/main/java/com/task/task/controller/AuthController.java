package com.task.task.controller;

import com.task.task.model.User;
import com.task.task.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        userService.register(user);
        model.addAttribute("message", "Registration successful");
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        boolean success = userService.login(user.getUsername(), user.getPassword());

        if (success) {
            if ("admin".equals(user.getUsername())) {
                return "redirect:/admin";
            }
            User loggedInUser = userService.findByUsername(user.getUsername());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("feedback", loggedInUser.getFeedback());
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @PostMapping("/feedback")
    public String submitFeedback(@RequestParam String username, @RequestParam String feedback, Model model) {
        userService.updateFeedback(username, feedback);
        model.addAttribute("username", username);
        model.addAttribute("feedback", feedback);
        model.addAttribute("message", "Feedback saved successfully!");
        return "home";
    }
}
