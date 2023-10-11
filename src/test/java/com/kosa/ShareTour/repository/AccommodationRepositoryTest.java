package com.kosa.ShareTour.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.kosa.ShareTour.entity.Accommodation;
import com.kosa.ShareTour.utils.STUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@SpringBootTest
@Transactional
class AccommodationRepositoryTest {

    @Autowired
    AccommodationRepository accommodationRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("숙소 리스트 생성 테스트")
    public void createAccommodationList(){
        // given
        for (int i = 1; i <= 3; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }

        //when
        var savedAccommodationList = accommodationRepository.findAll();

        // then
        assertThat(savedAccommodationList.size()).isEqualTo(3);
        System.out.println(savedAccommodationList);
    }

    @Test
    @DisplayName("숙소 상세주소로 조회 테스트")
    public void findByAddressTest(){
        //given
        String exampleAccommodation = "숙소 상세주소1";

        for (int i = 1; i <= 3; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        em.clear();

        //when
        var targetAccommodation = accommodationRepository.findByAddress(exampleAccommodation);

        // then
        assertThat(targetAccommodation.getAddress()).isNotNull();
        assertThat(targetAccommodation.getAddress()).isEqualTo(exampleAccommodation);
    }

    @Test
    @DisplayName("숙소 이름으로 조회 테스트")
    public void findByNameTest(){
        //given
        for (int i = 1; i <= 2; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        for (int i = 3; i <= 4; i++) {
            Accommodation accommodation = STUtils.getAccommodation("", String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        em.clear();

        //when
        var targetAccommodationList = accommodationRepository.findByName("숙소 이름");

        // then
        assertThat(targetAccommodationList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("숙소 도/시로 조회 테스트")
    public void findByAreaTest(){
        //given
        for (int i = 1; i <= 2; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        for (int i = 3; i <= 4; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i), "", String.valueOf(i), String.valueOf(i), String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        em.clear();

        //when
        var targetAccommodationList = accommodationRepository.findByArea("숙소 도/시");

        // then
        assertThat(targetAccommodationList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("숙소 등급으로 조회 테스트")
    public void findByGradeTest(){
        //given
        for (int i = 1; i <= 2; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        for (int i = 3; i <= 4; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i), String.valueOf(i), "", String.valueOf(i), String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        em.clear();

        //when
        var targetAccommodationList = accommodationRepository.findByGrade("숙소 등급");

        // then
        assertThat(targetAccommodationList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("숙소 주차장으로 조회 테스트")
    public void findByParkingTest(){
        //given
        for (int i = 1; i <= 2; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        for (int i = 3; i <= 4; i++) {
            Accommodation accommodation = STUtils.getAccommodation(String.valueOf(i), String.valueOf(i), String.valueOf(i), "", String.valueOf(i));
            accommodationRepository.saveAndFlush(accommodation);
        }
        em.clear();

        //when
        var targetAccommodationList = accommodationRepository.findByParking("숙소 주차장");

        // then
        assertThat(targetAccommodationList.size()).isEqualTo(2);
    }

}