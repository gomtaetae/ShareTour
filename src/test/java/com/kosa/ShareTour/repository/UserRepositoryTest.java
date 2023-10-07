package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.utils.STUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("유저 생성 테스트")
    public void createUserList(){
        // given
        User user = STUtils.getUser();

        userRepository.saveAndFlush(user);
        em.clear();

        //when
        var savedUser = userRepository.findById(user.getId()).orElseThrow();

        // then
        assertThat(savedUser.getUsername()).isEqualTo(user.getUsername());
        System.out.println(savedUser.toString());
    }

    @Test
    @DisplayName("유저 업데이트 테스트")
    public void updateUser() {
        // given
        User user = STUtils.getUser();
        userRepository.saveAndFlush(user);

        // when
        user.setUsername("새로운 이름");
        user.setEmail("newuser@email.com");
        user.setNickname("새로운 닉네임");
        user.setPassword("새로운 비밀번호");
        user.setImgUrl("새로운 이미지");
        user.setGender("새로운 성별");
        user.setBirthday(LocalDate.now());
        user.setMobile("새로운 전화번호");
        user.setAddress("새로운 주소");
        user.setGrade("새로운 등급");
        user.setPoint(999);
        userRepository.saveAndFlush(user);

        em.clear();

        // then
        var updatedUser = userRepository.findById(user.getId()).orElseThrow();
        assertThat(updatedUser.getNickname()).isEqualTo(user.getNickname());
    }

    @Test
    @DisplayName("유저 이름으로 조회 테스트")
    public void findByUserNmTest(){
        //given
        for (int i = 1; i <= 3; i++) {
            User user = STUtils.getUser(String.valueOf(i));
            userRepository.saveAndFlush(user);
        }
        for (int i = 4; i < 6; i++) {
            User user = STUtils.getUser("1", String.valueOf(i));
            userRepository.saveAndFlush(user);
        }
        em.clear();

        //when
        var userList = userRepository.findByUsername("유저 이름1");

        // then
        assertThat(userList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("유저 이메일로 조회 테스트")
    public void findByUserEmailTest(){
        //given
        String userEmail = "useremail@example.com";

        User user = STUtils.getUser();
        user.setEmail(userEmail);
        userRepository.saveAndFlush(user);

        //when
        em.clear();
        User targetUser = userRepository.findByEmail(userEmail);

        //then
        assertThat(targetUser.getEmail()).isNotNull();
        assertThat(targetUser.getEmail()).isEqualTo("useremail@example.com");
    }

    @Test
    @DisplayName("유저 닉네임으로 조회 테스트")
    public void findByUserNicknameTest(){
        //given
        String userNickname = "nickname1";

        User user = STUtils.getUser();
        user.setNickname(userNickname);
        userRepository.saveAndFlush(user);

        //when
        em.clear();
        User targetUser = userRepository.findByNickname(userNickname);

        //then
        assertThat(targetUser.getNickname()).isNotNull();
        assertThat(targetUser.getNickname()).isEqualTo("nickname1");
    }


    @Test
    @DisplayName("유저 ID 구분 삭제 테스트")
    public void deleteUsersByIdTest(){
        // given
        for (int i = 1; i <= 3; i++) {
            User user = STUtils.getUser(String.valueOf(i));
            userRepository.saveAndFlush(user);
        }
        em.clear();

        //when
        userRepository.deleteById(1);

        //then
        var userList = userRepository.findAll();
        assertThat(userList.size()).isEqualTo(2);
    }

}