package com.kosa.ShareTour.entity;

import com.kosa.ShareTour.constant.Role;
import com.kosa.ShareTour.dto.UserFormDto;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @Column(name="users_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Posting> postingList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername(userFormDto.getName());
        user.setEmail(userFormDto.getEmail());
        user.setNickname(userFormDto.getNickname());
        user.setPassword(userFormDto.getEmail());
        user.setCreateTime(LocalDateTime.now());
        user.setImgUrl(userFormDto.getImgUrl());
        user.setGender(userFormDto.getGender());
        user.setBirthday(userFormDto.getBirthday());
        user.setMobile(userFormDto.getPhone());
        user.setAddress(userFormDto.getAddress());
        user.setGrade(userFormDto.getGrade());
        user.setPoint(0);

        return user;
    }

}
