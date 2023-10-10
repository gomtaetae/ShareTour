package com.kosa.ShareTour.dto;

import lombok.Data;
import org.thymeleaf.spring5.processor.SpringErrorClassTagProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserFormDto {
    private String name;

    private String email;

    private String nickname;

    private String password;

    private LocalDateTime createTime;

    private String imgUrl;

    private String gender;

    private LocalDate birthday;

    private String phone;

    private String address;

    private String grade;
}
