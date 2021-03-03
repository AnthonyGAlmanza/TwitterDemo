package com.example.twitterdemo.controller;

import com.example.twitterdemo.model.Tweet;
import com.example.twitterdemo.model.User;
import com.example.twitterdemo.service.TweetService;
import com.example.twitterdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    //add more code here
    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable(value="username") String username, Model model) {
        User user = userService.findByUsername(username);
        List<Tweet> tweets = tweetService.findAllByUser(user);
        model.addAttribute("tweetList", tweets);
        model.addAttribute("user", user);
        return "user";
    }

}
