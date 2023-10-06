package com.kosa.ShareTour.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.kosa.ShareTour.entity.Posting;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.utils.STUtils;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
//@RequiredArgsConstructor
class PostingRepositoryTest {

    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager em;


    private Posting getPosting(String suffix) {
        var user = STUtils.getUser(suffix);
        userRepository.save(user);

        Posting posting = new Posting();
        posting.setTitle("게시글 제목" + suffix);
        posting.setContent("게시글 내용" + suffix);
        posting.setCreatedAt(LocalDateTime.now());
        posting.setUser(user);

        return posting;
    }

    @AfterEach
    public void cleanUp() {
        postingRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 생성 테스트")
    public void createPostingList(){
        // given
        Posting posting = getPosting("1");

        postingRepository.saveAndFlush(posting);
        em.clear();

        //when
        var savedPosting = postingRepository.findById(posting.getPostingId()).orElseThrow();

        // then
        assertThat(savedPosting.getTitle()).isEqualTo(posting.getTitle());
    }

    @Test
    @DisplayName("유저 ID로 게시글 조회 테스트")
    public void findByUserIdTest() {
        //given
        for (int i = 1; i <= 3; i++) {
            var posting = getPosting(String.valueOf(i));
            postingRepository.save(posting);
        }
        em.flush();
        em.clear();

        //when
        var savedPosting = postingRepository.findByUserId(1);

        //then
        assertThat(savedPosting.size()).isEqualTo(1);


    }




}