package com.kosa.ShareTour.utils;

import com.kosa.ShareTour.entity.Posting;
import com.kosa.ShareTour.entity.User;
import com.kosa.ShareTour.entity.Comment;
import com.kosa.ShareTour.entity.Admin;
import com.kosa.ShareTour.entity.Place;
import com.kosa.ShareTour.entity.Accommodation;
import com.kosa.ShareTour.entity.Landmark;
import com.kosa.ShareTour.entity.Restaurant;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// repository 주입은 test 혹은 기능을 사용하는 곳에서 실시, 우선 저장 되어야함.


public class STUtils {

    //유저 생성
    public static User getUser(String name, String suffix) {
        User user = new User();
        user.setUsername("유저 이름" + name);
        user.setEmail("user" + suffix + "@email.com");
        user.setNickname("유저 닉네임" + suffix);
        user.setPassword("유저 비밀번호" + suffix);
        user.setCreateTime(LocalDateTime.now());
        user.setImgUrl("유저 이미지" + suffix);
        user.setGender("유저 성별");
        user.setBirthday(LocalDate.now());
        user.setMobile("유저 전화번호" + suffix);
        user.setAddress("유저 주소" + suffix);
        user.setGrade("유저 등급");
        user.setPoint(10);

        return user;
    }
    public static User getUser() {
        return getUser("", "");
    }

    public static User getUser(String Suffix) {
        return getUser(Suffix, Suffix);
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

    // 관리자 생성
    public static Admin getAdmin(String suffix) {
        Admin admin = new Admin();
        admin.setName("관리자" + suffix);
        admin.setPassword("비밀번호" + suffix);

        return admin;
    }

    public static Admin getAdmin() {
        return getAdmin("");
    }

    // Place 생성
    public static Place getPlace(String suffix) {
        Place place = new Place();
        place.setCountry("여행지(국가)" + suffix);
        place.setProvince("여행지(도)" + suffix);
        place.setCity("여행지(시)" + suffix);
        place.setLocX("위도" + suffix);
        place.setLocY("경도" + suffix);
        place.setImg("이미지" + suffix);

        return place;
    }

    public static Place getPlace() {
        return getPlace("");
    }

    // Accommodation 생성
    public static Accommodation getAccommodation(String name, String area, String grade, String parking, String suffix) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName("숙소 이름" + name);
        accommodation.setAddress("숙소 상세주소" + suffix);
        accommodation.setUrl("숙소 url" + suffix);
        accommodation.setPhone("숙소 전화번호" + suffix);
        accommodation.setArea("숙소 도/시" + area);
        accommodation.setGrade("숙소 등급" + grade);
        accommodation.setParking("숙소 주차장" + parking);
        accommodation.setLocX("위도" + suffix);
        accommodation.setLocY("경도" + suffix);
        accommodation.setPrice(100.0000F);

        return accommodation;
    }

    public static Accommodation getAccommodation(String suffix) {
        return getAccommodation(suffix, suffix, suffix, suffix, suffix);
    }
    public static Accommodation getAccommodation() {
        return getAccommodation("","", "", "", "");
    }

    // Landmark 생성
    public static Landmark getLandmark(String suffix) {
        Landmark landmark = new Landmark();
        landmark.setName("명소/활동 이름" + suffix);
        landmark.setCategory("명소/활동 종류" + suffix);
        landmark.setAddress("명소/활동 주소" + suffix);
        landmark.setUrl("명소/활동 url" + suffix);
        landmark.setPhone("명소/활동 전화번호" + suffix);
        landmark.setArea("명소/활동 도/시" + suffix);
        landmark.setParking("명소/활동 주차" + suffix);
        landmark.setLocX("위도" + suffix);
        landmark.setLocY("경도" + suffix);
        landmark.setPrice(100.0000F);

        return landmark;
    }

    public static Landmark getLandmark() {
        return getLandmark("");
    }

    // Restaurant 생성
    public static Restaurant getRestaurant(String suffix) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("식당 이름" + suffix);
        restaurant.setAddress("명소/활동 주소" + suffix);
        restaurant.setPhone("명소/활동 전화번호" + suffix);
        restaurant.setArea("명소/활동 도/시" + suffix);
        restaurant.setParking("명소/활동 주차" + suffix);
        restaurant.setLocX("위도" + suffix);
        restaurant.setLocY("경도" + suffix);
        restaurant.setPrice(100.0000F);

        return restaurant;
    }

    public static Restaurant getRestaurant() {
        return getRestaurant("");
    }






}

