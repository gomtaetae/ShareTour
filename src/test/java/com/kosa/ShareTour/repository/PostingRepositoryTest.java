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
    PostingRepository postingRepository;
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager em;


    @Test
    @DisplayName("게시글 생성 테스트")
    public void createPostingList(){
        // given
        var posting = STUtils.getPosting();
        var user = posting.getUser();
        System.out.println(user);
        System.out.println(posting);
        userRepository.save(user);
        postingRepository.saveAndFlush(posting);
        em.clear();

        //when
        var savedPosting = postingRepository.findById(posting.getId()).orElseThrow();

        // then
        assertThat(savedPosting.getTitle()).isEqualTo(posting.getTitle());
        System.out.println(savedPosting.toString());
    }

    @Test
    @DisplayName("제목으로 게시글 조회 테스트")
    public void findByTitleTest(){
        //given
        for (int i= 1; i <= 3; i++) {
            var posting = STUtils.getPosting((String.valueOf(i)));
            var user = posting.getUser();
            userRepository.save(user);
            postingRepository.saveAndFlush(posting);
        }
        em.clear();

        //when
        var savedPosting = postingRepository.findByTitle("게시글 제목1");

        //then
        assertThat(savedPosting.size()).isEqualTo(1);
        System.out.println(savedPosting.toString());

    }

    @Test
    @DisplayName("유저 ID로 게시글 조회 테스트")
    public void findByUserIdTest() {
        //given
        for (int i = 1; i <= 3; i++) {
            var posting = STUtils.getPosting(String.valueOf(i));
            var user = posting.getUser();
            userRepository.save(user);
            postingRepository.saveAndFlush(posting);
        }
        em.clear();

        //when
        var savedPosting = postingRepository.findByUserId(1);

        //then
        assertThat(savedPosting.size()).isEqualTo(1);
        System.out.println(savedPosting.toString());

    }

    @Test
    @DisplayName("게시글(유저와 함께) 전체 조회 테스트")
    public void findAllPosting() {
        //given *true : each가 맞다, 각각의 유저별로 게시글을 작성한 상태, false : each가 아니다, 한 유저가 작성한 게시글들

        var postings = STUtils.getPostings(3, true);
        for (var posting : postings) {
            userRepository.save(posting.getUser());
            postingRepository.saveAndFlush(posting);
        }
        em.clear();

        //when
        var savedPosting = postingRepository.findAll();
        System.out.println(savedPosting.toString());

        // then
        assertThat(savedPosting.size()).isEqualTo(postings.size());
    }



}