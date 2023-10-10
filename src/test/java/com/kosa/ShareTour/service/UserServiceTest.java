package com.kosa.ShareTour.service;

import com.kosa.ShareTour.dto.UserFormDto;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.repository.UserRepository;
import com.kosa.ShareTour.service.UserService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setName("홍길동");
        userFormDto.setEmail("test@email.com");
        userFormDto.setNickname("Hongs");
        userFormDto.setPassword("1234");
        userFormDto.setCreateTime(LocalDateTime.now());
        userFormDto.setGender("남성");
        userFormDto.setBirthday(LocalDate.parse("2023-10-10"));
        userFormDto.setPhone("010-1234-5678");
        userFormDto.setAddress("서울시 마포구 합정동");
        userFormDto.setGrade("1급");
        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest(){
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getUsername(), savedUser.getUsername());
        assertEquals(user.getAddress(), savedUser.getAddress());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getRole(), savedUser.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateUserTest(){
        User user1 = createUser();
        User user2 = createUser();
        userService.saveUser(user1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            userService.saveUser(user2);});
        assertEquals("이미 가입된 회원입니다.", e.getMessage());
    }



}