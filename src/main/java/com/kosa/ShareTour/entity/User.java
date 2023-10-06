package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name="users_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name="username", length = 32, nullable = false)
    private String username;

    @Column(name="email", length = 60, nullable = false, unique = true)
    private String email;

    @Column(name="nickname", length = 45, nullable = false, unique = true)
    private String nickname;

    @Column(name="password", length = 30, nullable = false)
    private String password;

    @Column(name="create_time")
    private LocalDateTime createTime;

    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
    }

    @Column(name="img")
    private String imgUrl;

    @Column(name="gender", length = 45, nullable = false)
    private String gender;

    @Column(name="birthday", nullable = false)
    private LocalDate birthday;

    @Column(name="mobile", length = 45, nullable = false)
    private String mobile;

    @Column(name="address", length = 45, nullable = false)
    private String address;

    @Column(name="grade", length = 45, nullable = false)
    private String grade;

    @Column(name="point")
    private int point;

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