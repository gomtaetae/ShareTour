package com.kosa.ShareTour.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
//    public void cleanUp() {
//       userRepository.deleteAll();
//   }

    @Test
    @DisplayName("유저 생성 테스트")
    public void createUserList() {
        // given
        User user = getUser();

        userRepository.saveAndFlush(user);
        em.clear();

        //when
        var savedUser = userRepository.findById(user.getUserid()).orElseThrow();

        // then
        assertThat(savedUser.getUsername()).isEqualTo(user.getUsername());
    }
}