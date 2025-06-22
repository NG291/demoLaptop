package com.example.demo.controller.admin;

import com.example.demo.domain.User;
import com.example.demo.service.UploadService;
import com.example.demo.service.UserService;

import jakarta.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

    // List
    @RequestMapping("/admin/user")
    public String GetUserPage(Model model) {
        List<User> users = this.userService.GetAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    // Get user by id
    @RequestMapping("/admin/user/{id}")
    public String GetUserDetailPage(Model model, @PathVariable Long id) {
        Optional<User> userDetail = this.userService.getUserById(id);
        model.addAttribute("user", userDetail.get());
        return "admin/user/detail";
    }

    // Create
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String CreateUserPage(Model model,
            @ModelAttribute("newUser") User newUser,
            @RequestParam("imageFile") MultipartFile file) {
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        // this.userService.handelSaveUser(newUser);
        return "redirect:/admin/user";
    }

    // Update
    @RequestMapping("/admin/user/update/{id}")
    public String GetUserDetailPageUpdate(Model model, @PathVariable Long id) {
        Optional<User> userDetail = this.userService.getUserById(id);
        model.addAttribute("userUpdate", userDetail.get());
        return "admin/user/update";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String GetUserDetailUpdate(Model model, @ModelAttribute("userUpdate") User userUpdate) {
        this.userService.handelSaveUser(userUpdate);
        return "redirect:/admin/user";
    }

    // Delete
    @RequestMapping("/admin/user/delete/{id}")
    public String GetUserDetailPageDelete(Model model, @PathVariable Long id) {
        Optional<User> userDetail = this.userService.getUserById(id);
        model.addAttribute("user", userDetail.get());
        return "admin/user/delete";
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    public String DeleteInfoUser(Model model, @RequestParam Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/path")
    public String getMethodName() {
        return "admin/user/create";
    }

}
