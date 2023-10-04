package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.mysema.query.jpa.impl.JPAQueryFactory;
import com.mysema.query.jpa.impl.JPAQuery;
import com.kosa.ShareTour.entity.QUser;

import javax.inject.Provider;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class UserRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 생성 테스트.")

    public void createUserList(){
        for(int i=1; i<=10; i++){
            User user = new User();
            user.setUsername("유저 이름 " + i + ".");
            user.setEmail("user@email" + i);
            user.setNickname("유저 닉네임 " + i + ".");
            user.setPassword("유저 비밀번호" + i + ".");
            user.setCreate_time(LocalDateTime.now());
            user.setImg("유저 이미지" + i + ".");
            user.setGender("유저 성별" + i + ".");
            user.setBirthday(LocalDate.now());
            user.setMobile("유저 전화번호" + i + ".");
            user.setAddress("유저 주소" + i + ".");
            user.setGrade("유저 등급" + i + ".");
            user.setPoint(i);
        }
    }

}
