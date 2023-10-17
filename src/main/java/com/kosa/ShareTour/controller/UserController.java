package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.MemberFormDto;
import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.repository.MemberRepository;
import com.kosa.ShareTour.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @GetMapping("/profile")
    public String userProfile(Model model) {
        // 현재 사용자 정보 가져오는 코드 (Spring Security를 통해)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Member member = memberRepository.findByEmail(email);
        model.addAttribute("member", member);
        return "user/profile";
    }

    @PostMapping("/profile")
    public String updateUserProfile(@ModelAttribute MemberFormDto memberDto) {
        // 사용자 정보 업데이트 및 저장
        memberService.updateMemberProfile(memberDto);
        return "redirect:/user/profile";
    }

}
