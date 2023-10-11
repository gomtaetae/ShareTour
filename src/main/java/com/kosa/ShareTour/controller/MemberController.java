package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.MemberFormDto;
import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@RequestMapping("")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/register")
    public String memberForm(Model model){
        /*객체만들어주기*/
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/register";
    }

    @PostMapping(value = "/register")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "members/register";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "members/register";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "members/login";
    }


    @GetMapping(value = "/login/error")
    public String loginForm(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "members/login";
    }




}