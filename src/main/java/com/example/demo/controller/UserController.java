package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/nguyen")
    public String AnhYeuVo(Model model) {
        String aye = userService.handler();
        model.addAttribute("beYeu", aye);
        return "commeno";
    }
}