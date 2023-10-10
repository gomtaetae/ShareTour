package com.kosa.ShareTour.service;

import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user){
        User findUser = userRepository.findByEmail(user.getEmail());
        if(findUser !=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }



}