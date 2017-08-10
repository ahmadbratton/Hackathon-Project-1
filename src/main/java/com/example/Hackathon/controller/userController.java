package com.example.Hackathon.controller;


import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/user")
public class userController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session) {
        User foundUser = userRepo.findByEmail(email);

        if (foundUser == null) {
            return "user not found";
        }

        if (foundUser.getPassword().equals(password)) {
            session.setAttribute("userId", foundUser.getUserId());
            return "user login successful";
        } else {
            return "No user/password combination";
        }
    }

    @PostMapping("/register")
    public String register(String email, String password, String firstName, String lastName) {
        // TODO: 8/10/17 add checks
        User newUser = new User();

        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        userRepo.save(newUser);

        return "created new user";

    }


}
