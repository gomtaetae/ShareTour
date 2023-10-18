//package com.kosa.ShareTour.service;
//
//import com.kosa.ShareTour.dto.UserDto;
//import com.kosa.ShareTour.entity.Member;
//import com.kosa.ShareTour.repository.MemberRepository;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Override
//    public List<UserDto> getAllUsers() {
//        List<Member> members = memberRepository.findAll();
//
//        return members.stream()
//                .map(user -> convertToDto(user))
//    }
//}
