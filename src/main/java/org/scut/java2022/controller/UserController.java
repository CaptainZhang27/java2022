package org.scut.java2022.controller;

import org.scut.java2022.pojo.User;
import org.scut.java2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user){
        if(userService.check(user.getUserName(),user.getPassword()))
            return "1";
        else
            return  "The entered password or user name is incorrect";
    }
}
