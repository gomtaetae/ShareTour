package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.MemberFormDto;
import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다(동일한 Email을 사용하는 계정 존재)");
        }

        Member findMemberNick = memberRepository.findByNickname(member.getNickname());
        if(findMemberNick != null) {
            throw new IllegalStateException("이미 사용중인 아이디 입니다");
        }

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }


    public String getCurrentLoggedInMemberNickname() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        Member member = memberRepository.findByEmail(email);
//                .orElseThrow(EntityNotFoundException::new);

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }

        return member.getNickname();
    }

    //ChatGPT
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Member updateMemberProfile(MemberFormDto memberFormDto) {
        // 현재 사용자 정보 가져오는 코드
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Member member = memberRepository.findByEmail(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

        // 업데이트할 정보를 Member 엔티티에 설정
        member.setPassword(memberFormDto.getPassword());
        member.setImgUrl(memberFormDto.getImgUrl());
        member.setGender(memberFormDto.getGender());
        member.setPhone(memberFormDto.getPhone());
        member.setAddressMain(memberFormDto.getAddressMain());
        member.setAddressSub(memberFormDto.getAddressSub());
        // 다른 필드도 필요에 따라 업데이트

        return memberRepository.save(member);
    }


}
