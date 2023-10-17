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
    private MemberService memberService;

    @GetMapping("/profile/edit")
    public String editUserProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Member member = memberService.findByEmail(email);

        // member 객체를 memberFormDto로 변환하여 모델에 추가
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail(member.getEmail());
        memberFormDto.setName(member.getUsername());
        model.addAttribute("memberFormDto", member);

        return "member/memberProfile";
    }

    @PostMapping("/profile/edit")
    public String updateUserProfile(@ModelAttribute MemberFormDto memberDto, Model model) {
        Member updatedMember = memberService.updateMemberProfile(memberDto);
        if (updatedMember != null) {
            model.addAttribute("successMessage", "프로필이 성공적으로 업데이트되었습니다.");
            return "redirect:/";
        }

        model.addAttribute("errorMessage", "프로필 업데이트 중에 문제가 발생했습니다.");

        return "redirect:/user/profile/edit";
    }

}
