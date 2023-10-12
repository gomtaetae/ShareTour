package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.AdminFormDto;
import com.kosa.ShareTour.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.kosa.ShareTour.entity.Admin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@RequestMapping("/admins")
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

//    @GetMapping(value = "/register")
//    public String memberForm(Model model){
//        /*객체만들어주기*/
//        model.addAttribute("memberFormDto", new MemberFormDto());
//        return "members/register";
//    }

    @GetMapping(value = "/new")
    public String memberForm(Model model){
        model.addAttribute("adminFormDto", new AdminFormDto());
        return "admin/adminForm";
    }


    @PostMapping(value = "/new")
    public String adminForm(@Valid AdminFormDto adminFormDto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "admin/adminForm";
        }

        try {
            Admin admin = Admin.createAdmin(adminFormDto, passwordEncoder);
            adminService.saveAdmin(admin);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "admin/adminForm";
        }

        return "redirect:/";
    }


    @GetMapping(value = "/login")
    public String loginAdmin(){
        return "admin/adminLogin";
    }


    @GetMapping(value = "/login/error")
    public String loginForm(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "admin/adminLogin";
    }


}