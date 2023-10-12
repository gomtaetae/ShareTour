package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.MemberFormDto;
import com.kosa.ShareTour.entity.Member;
//import com.kosa.ShareTour.repository.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

//    @Autowired
//    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("홍길동");
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setNickname("Hongs");
        memberFormDto.setPassword("12345678");
//        memberFormDto.setCreateTime(LocalDateTime.now());
        memberFormDto.setGender("남성");
        memberFormDto.setBirthday("2023-10-10");
        memberFormDto.setPhone("010-1234-5678");
        memberFormDto.setAddressMain("서울시 마포구 합정동");
        memberFormDto.setGrade("1급");

        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

//        Member retrievedMember = memberRepository.findById(savedMember.getId()).orElse(null);
//
//        assertEquals(member.getEmail(), retrievedMember.getEmail());
//        assertEquals(member.getUsername(), retrievedMember.getUsername());
//        assertEquals(member.getAddress(), retrievedMember.getAddress());
//        assertEquals(member.getPassword(), retrievedMember.getPassword());
//        assertEquals(member.getRole(), retrievedMember.getRole());

        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getUsername(), savedMember.getUsername());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest(){
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);});
        assertEquals("이미 가입된 회원입니다.", e.getMessage());
    }

}