//package com.kosa.ShareTour.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.kosa.ShareTour.entity.Place;
//import com.kosa.ShareTour.utils.STUtils;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//@SpringBootTest
//@Transactional
//class PlaceRepositoryTest {
//
//    @Autowired
//    PlaceRepository placeRepository;
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Test
//    @DisplayName("여행지 리스트 생성 테스트")
//    public void createPlaceList(){
//        // given
//        for (int i = 1; i <= 3; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//
//        //when
//        var savedPlaceList = placeRepository.findAll();
//
//        // then
//        assertThat(savedPlaceList.size()).isEqualTo(3);
//        System.out.println(savedPlaceList);
//    }
//
//    @Test
//    @DisplayName("여행지 국가로 조회 테스트")
//    public void findByCountryTest() {
//        //given
//        for (int i = 1; i <= 2; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        for (int i = 3; i <= 4; i++) {
//            Place place = STUtils.getPlace("", String.valueOf(i), String.valueOf(i), String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        em.clear();
//
//        //when
//        var targetPlaceList = placeRepository.findByCountry("여행지(국가)");
//
//        // then
//        assertThat(targetPlaceList.size()).isEqualTo(2);
//    }
//
//    @Test
//    @DisplayName("여행지 도로 조회 테스트")
//    public void findByProvinceTest() {
//        //given
//        for (int i = 1; i <= 2; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        for (int i = 3; i <= 4; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i), "", String.valueOf(i), String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        em.clear();
//
//        //when
//        var targetPlaceList = placeRepository.findByProvince("여행지(도)");
//
//        // then
//        assertThat(targetPlaceList.size()).isEqualTo(2);
//    }
//
//    @Test
//    @DisplayName("여행지 시로 조회 테스트")
//    public void findByCityTest() {
//        //given
//        for (int i = 1; i <= 2; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        for (int i = 3; i <= 4; i++) {
//            Place place = STUtils.getPlace(String.valueOf(i), String.valueOf(i), "", String.valueOf(i));
//            placeRepository.saveAndFlush(place);
//        }
//        em.clear();
//
//        //when
//        var targetPlaceList = placeRepository.findByCity("여행지(시)");
//
//        // then
//        assertThat(targetPlaceList.size()).isEqualTo(2);
//    }
//
//}