package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.MemberFormDto;
import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.service.MemberService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(String email, String password){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("홍길동");
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setNickname("Hongs");
        memberFormDto.setPassword("1234");
        memberFormDto.setCreateTime(LocalDateTime.now());
        memberFormDto.setGender("남성");
        memberFormDto.setBirthday(LocalDate.parse("2023-10-10"));
        memberFormDto.setPhone("010-1234-5678");
        memberFormDto.setAddress("서울시 마포구 합정동");
        memberFormDto.setGrade("1급");

        Member member = Member.createMember(memberFormDto, passwordEncoder);
        return memberService.saveMember(member);
    }



}