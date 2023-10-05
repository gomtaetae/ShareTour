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
    private int userid;

    @Column(name="username", length = 32, nullable = false)
    private String username;

    @Column(name="email", length = 60, nullable = false)
    private String email;

    @Column(name="nickname", length = 45, nullable = false)
    private String nickname;

    @Column(name="password", length = 30, nullable = false)
    private String password;

    @Column(name="create_time")
    private LocalDateTime create_time;

    @PrePersist
    protected void onCreate() {
        create_time = LocalDateTime.now();
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

}
