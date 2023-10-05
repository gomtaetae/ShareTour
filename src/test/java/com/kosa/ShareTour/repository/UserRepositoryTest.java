package com.kosa.ShareTour.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.kosa.ShareTour.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager em;

    private User getUser() {
        return this.getUser("");
    }

    private User getUser(String suffix) {
        User user = new User();
        user.setUsername("유저 이름" + suffix);
        user.setEmail("user" + suffix + "@email.com");
        user.setNickname("유저 닉네임" + suffix);
        user.setPassword("유저 비밀번호" + suffix);
        user.setCreate_time(LocalDateTime.now());
        user.setImgUrl("유저 이미지" + suffix);
        user.setGender("유저 성별");
        user.setBirthday(LocalDate.now());
        user.setMobile("유저 전화번호");
        user.setAddress("유저 주소");
        user.setGrade("유저 등급");
        user.setPoint(10);

        return user;
    }

//    @AfterEach
//   public void cleanUp() {
//       userRepository.deleteAll();
//   }

    @Test
    @DisplayName("유저 생성 테스트")
    public void createUserList(){
        // given
        User user = getUser();

        userRepository.saveAndFlush(user);
        em.clear();

        //when
        var savedUser = userRepository.findById(user.getUserid()).orElseThrow();

        // then
        assertThat(savedUser.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    @DisplayName("유저 업데이트 테스트")
    public void updateUser() {
        // given
        User user = getUser();
        userRepository.saveAndFlush(user);

        // when
        user.setUsername("새로운 이름");
        user.setEmail("newuser@email.com");
        user.setNickname("새로운 닉네임");
        user.setPassword("새로운 비밀번호");
        user.setImgUrl("새로운 이미지");
        user.setGender("세로운 성별");
        user.setBirthday(LocalDate.now());
        user.setMobile("새로운 전화번호");
        user.setAddress("새로운 주소");
        user.setGrade("새로운 등급");
        user.setPoint(999);
        userRepository.saveAndFlush(user);

        em.clear();

        // then
        var updatedUser = userRepository.findById(user.getUserid()).orElseThrow();
        assertThat(updatedUser.getNickname()).isEqualTo(user.getNickname());
    }

    @Test
    @DisplayName("유저 이름으로 조회 테스트")
    public void findByUserNmTest(){
        //given
        for (int i = 1; i <= 3; i++) {
            User user = getUser(String.valueOf(i));
            userRepository.saveAndFlush(user);
        }
        for (int i = 0; i < 2; i++) {
            User user = getUser(String.valueOf(1));
            userRepository.saveAndFlush(user);
        }
        em.clear();

        //when
        var userList = userRepository.findByUsername("유저 이름1");
        assertThat(userList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("유저 이메일로 조회 테스트")
    public void findByUserEmailTest(){
        //given
        String userEmail = "useremail@example.com";

        User user = getUser("");
        user.setEmail(userEmail);
        userRepository.saveAndFlush(user);

        //when
        List<User> userList = userRepository.findByEmail(userEmail);

        //then
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(1);
        User foundUser = userList.get(0);
        assertThat(foundUser.getEmail()).isEqualTo(userEmail);
    }


    @Test
    @DisplayName("유저 ID 구분 삭제 테스트")
    public void deleteUsersByIdTest(){
        // given
        for (int i = 1; i <= 3; i++) {
            User user = getUser(String.valueOf(1));
            userRepository.saveAndFlush(user);
        }
        em.clear();

        //when
        userRepository.deleteById(1);

        //then
        var userList = userRepository.findByUsername("유저 이름1");
        assertThat(userList.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("유저 전체 조회 테스트")
    public void findAllUsersIdTest(){
        // given
        for (int i = 1; i <= 4; i++) {
            User user = getUser(String.valueOf(i));
            userRepository.saveAndFlush(user);
        }
        em.clear();

        //when
        var userList = userRepository.findAll();

        //then
        for(var allUser : userList){
            System.out.println(allUser.toString());
        }
    }

}