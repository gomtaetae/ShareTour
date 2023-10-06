package com.kosa.ShareTour.utils;

import com.kosa.ShareTour.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class STUtils {
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

}
