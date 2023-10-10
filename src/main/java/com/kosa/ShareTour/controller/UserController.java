package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.UserFormDto;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String userForm(Model model){
        model.addAttribute("userFormDto",new UserFormDto());
        return "user/userForm";
    }

    @PostMapping(value = "/new")
    public String newUser(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "User/UserForm";
        }

        try {
            User user = User.createUser(userFormDto, passwordEncoder);
            userService.saveUser(user);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "user/userForm";
        }

        return "redirect:/";
    }




}
