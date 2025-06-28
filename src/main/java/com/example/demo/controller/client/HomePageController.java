package com.example.demo.controller.client;

import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public HomePageController(ProductService productService,
                              UserService userService,
                              PasswordEncoder passwordEncoder) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerUser") @Valid RegisterDTO registerUser,
                           BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(">>>>" + error.getField() + "-" + error.getDefaultMessage());
        }
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }
        User user = this.userService.registerUserToUser(registerUser);
        String HashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(HashPassword);
        user.setRole(userService.getRoleByName("USER"));
        this.userService.handelSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        return "client/auth/login";
    }
}

