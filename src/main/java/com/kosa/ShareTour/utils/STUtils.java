package com.kosa.ShareTour.utils;

import com.kosa.ShareTour.entity.Posting;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// repository 주입은 test 혹은 기능을 사용하는 곳에서 실시, 우선 저장 되어야함.


public class STUtils {

    //유저 생성
    public static User getUser(String name, String uniqueSuffix) {
        User user = new User();
        user.setUsername("유저 이름" + name);
        user.setEmail("user" + uniqueSuffix + "@email.com");
        user.setNickname("유저 닉네임" + uniqueSuffix);
        user.setPassword("유저 비밀번호" + uniqueSuffix);
        user.setCreateTime(LocalDateTime.now());
        user.setImgUrl("유저 이미지" + uniqueSuffix);
        user.setGender("유저 성별");
        user.setBirthday(LocalDate.now());
        user.setMobile("유저 전화번호");
        user.setAddress("유저 주소");
        user.setGrade("유저 등급");
        user.setPoint(10);

        return user;
    }
    public static User getUser() {
        return getUser("", "");
    }

    public static User getUser(String uniqueSuffix) {
        return getUser(uniqueSuffix, uniqueSuffix);
    }

    // 게시글 작성
    public static Posting getPosting(String suffix) {
        var user = STUtils.getUser(suffix);

        Posting posting = new Posting();
        posting.setTitle("게시글 제목" + suffix);
        posting.setContent("게시글 내용" + suffix);
        posting.setCreatedAt(LocalDateTime.now());
        posting.setUser(user);

        return posting;
    }

    public static Posting getPosting() {
        return getPosting("");
    }

    // 각 유저가 작성한 글, 혹은 한 유저가 여러 글을 동시 작성한 상태를 만들기 위한 생성 코드
    public static List<Posting> getPostings(int numOfPosts, boolean each) {
        var postings = new ArrayList<Posting>();
        var user = STUtils.getUser();

        for (int i = 1; i <= numOfPosts; i++) {
            if (each) {
                user = getUser(String.valueOf(i));
            }
            var posting = getPosting(String.valueOf(i));
            posting.setUser(user);
            postings.add(posting);
        }
        return postings;
    }

}

