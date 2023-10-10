package com.kosa.ShareTour.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.kosa.ShareTour.entity.Accommodation;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.utils.STUtils;
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

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class AccommodationRepositoryTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("숙소 저장 테스트")
    public void createAccommodationList(){
        Accommodation accommo = STUtils.getAccommodation();

        accommodationRepository.saveAndFlush(accommo);
        em.clear();

        var savedAccommodation = accommodationRepository.findById(accommo.getId()).orElseThrow();

        assertThat(savedAccommodation.getName()).isEqualTo(accommo.getName());
        System.out.println(savedAccommodation.toString());
    }

    @Test
    @DisplayName("숙소 업데이트 테스트")
    public void updateAccommodation() {
        // given
        Accommodation accommo = STUtils.getAccommodation();
        accommodationRepository.saveAndFlush(accommo);

        // when
        accommo.setName("새로운이름");
        accommo.setAddress("새로운주소");
        accommo.setUrl("https://www.naver.com");
        accommo.setPhone("010-2342-2234");
        accommo.setArea("경기도");
        accommo.setGrade("4성급");
        accommo.setParking("주차 가능");
        accommo.setLocX("27.234453");
        accommo.setLocY("36.674557");
        accommo.setPrice(100000);
        accommodationRepository.saveAndFlush(accommo);

        em.clear();

        // then
        var updatedAccommodation = accommodationRepository.findById(accommo.getId()).orElseThrow();
        assertThat(updatedAccommodation.getName()).isEqualTo(accommo.getName());
    }

    @Test
    @DisplayName("숙소 이름으로 조회 테스트")
    public void findByName(){
        //given
        for (int i = 1; i <= 3; i++) {
            Accommodation accommo = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommo);
        }
        for (int i = 4; i < 6; i++) {
            Accommodation accommo = STUtils.getAccommodation("1", String.valueOf(i));
            accommodationRepository.saveAndFlush(accommo);
        }
        em.clear();

        //when
        var accommodationList = accommodationRepository.findByName("숙소이름1");

        // then
        assertThat(accommodationList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("숙소 지역으로 조회 테스트")
    public void findByArea(){
        //given
        String accommodationArea = "경기도";

        Accommodation accommo = STUtils.getAccommodation();
        accommo.setArea(accommodationArea);
        accommodationRepository.saveAndFlush(accommo);

        //when
        em.clear();
        Accommodation targetAccommodation = accommodationRepository.findByArea(accommodationArea);

        //then
        assertThat(targetAccommodation.getArea()).isNotNull();
        assertThat(targetAccommodation.getArea()).isEqualTo("경기도");
    }

    @Test
    @DisplayName("숙소 가격으로 조회 테스트")
    public void findByPrice(){
        //given
        float accommodationPrice = 100000;

        Accommodation accommo = STUtils.getAccommodation();
        accommo.setPrice(accommodationPrice);
        accommodationRepository.saveAndFlush(accommo);

        //when
        em.clear();
        Accommodation targetAccommodation = accommodationRepository.findByprice(accommodationPrice);

        //then
        assertThat(targetAccommodation.getPrice()).isNotNull();
        assertThat(targetAccommodation.getPrice()).isEqualTo(100000);
    }


    @Test
    @DisplayName("숙소 ID 구분 삭제 테스트")
    public void deleteAccommoByIdTest(){
        // given
        for (int i = 1; i <= 3; i++) {
            var accommo = STUtils.getAccommodation(String.valueOf(i));
            var admin = accommo.getId();
            userRepository.save(user);
            postingRepository.saveAndFlush(posting);
        }
        em.clear();

        //when
        userRepository.deleteById(1);

        //then
        var userList = userRepository.findAll();
        assertThat(userList.size()).isEqualTo(2);
    }

}