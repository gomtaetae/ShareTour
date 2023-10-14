package com.kosa.ShareTour.repository;

import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.utils.STUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostingRepository postingRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("유저 생성 테스트")
    public void createUserList(){
        // given
        Member member = STUtils.getMember();

        memberRepository.saveAndFlush(member);
        em.clear();

        //when
        var savedUser = memberRepository.findById(member.getId()).orElseThrow();

        // then
        assertThat(savedUser.getUsername()).isEqualTo(member.getUsername());
        System.out.println(savedUser);
    }

    @Test
    @DisplayName("유저 업데이트 테스트")
    public void updateUser() {
        // given
        Member member = STUtils.getMember();
        memberRepository.saveAndFlush(member);

        // when
        member.setUsername("새로운 이름");
        member.setEmail("newuser@email.com");
        member.setNickname("새로운 닉네임");
        member.setPassword("새로운 비밀번호");
        member.setImgUrl("새로운 이미지");
        member.setGender("새로운 성별");
        member.setBirthday(LocalDate.now());
        member.setMobile("새로운 전화번호");
        member.setAddress("새로운 주소");
        member.setGrade("새로운 등급");
        member.setPoint(999);
        memberRepository.saveAndFlush(member);

        em.clear();

        // then
        var updatedUser = memberRepository.findById(member.getId()).orElseThrow();
        assertThat(updatedUser.getNickname()).isEqualTo(member.getNickname());
    }

    @Test
    @DisplayName("유저 이름으로 조회 테스트")
    public void findByUserNmTest(){
        //given
        for (int i = 1; i <= 3; i++) {
            Member member = STUtils.getMember(String.valueOf(i));
            memberRepository.saveAndFlush(member);
        }
        for (int i = 4; i < 6; i++) {
            Member member = STUtils.getMember("1", String.valueOf(i));
            memberRepository.saveAndFlush(member);
        }
        em.clear();

        //when
        var userList = memberRepository.findByUsername("멤버 이름1");

        // then
        assertThat(userList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("유저 이메일로 조회 테스트")
    public void findByUserEmailTest(){
        //given
        String memberEmail = "useremail@example.com";

        Member member = STUtils.getMember();
        member.setEmail(memberEmail);
        memberRepository.saveAndFlush(member);

        //when
        em.clear();
        var targetMember = memberRepository.findByEmail(memberEmail)
                .orElseThrow(EntityNotFoundException::new);

        //then
        assertThat(targetMember.getEmail()).isNotNull();
        assertThat(targetMember.getEmail()).isEqualTo(memberEmail);
    }

    @Test
    @DisplayName("유저 닉네임으로 조회 테스트")
    public void findByUserNicknameTest(){
        //given
        String memberNickname = "nickname1";

        Member member = STUtils.getMember();
        member.setNickname(memberNickname);
        memberRepository.saveAndFlush(member);

        //when
        em.clear();
        Member targetMember = memberRepository.findByNickname(memberNickname);

        //then
        assertThat(targetMember.getNickname()).isNotNull();
        assertThat(targetMember.getNickname()).isEqualTo("nickname1");
    }

    //ID 구분으로 삭제시 시퀀스 문제(예상하는 ID값이 아닐 수 있음, 시퀀스 자동 생성으로 인해)
//    @Test
//    @DisplayName("유저 ID 구분 삭제 테스트")
//    public void deleteUsersByIdTest(){
//        // given
//        for (int i = 1; i <= 3; i++) {
//            var posting = STUtils.getPosting(String.valueOf(i));
//            var user = posting.getUser();
//            userRepository.save(user);
//            postingRepository.saveAndFlush(posting);
//        }
//        em.clear();
//
//        //when
//        userRepository.deleteById(1);
//
//        //then
//        var userList = userRepository.findAll();
//        assertThat(userList.size()).isEqualTo(2);
//    }

    @Test
    @DisplayName("멤버 닉네임 구분 삭제 테스트")
    public void deleteMembersByNicknameTest(){
        // given
        for (int i = 1; i <= 3; i++) {
            var posting = STUtils.getPosting(String.valueOf(i));
            var member = posting.getMember();
            memberRepository.save(member);
            postingRepository.saveAndFlush(posting);
        }
        em.clear();

        //when
        memberRepository.deleteByNickname("멤버 닉네임1");

        //then
        var memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }

}