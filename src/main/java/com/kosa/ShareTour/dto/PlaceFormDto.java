package com.kosa.ShareTour.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PlaceFormDto {

    @NotBlank(message = "나라는 필수 입력 값 입니다.")
    private String country;

    @NotBlank(message = "시/도는 필수 입력 값 입니다.")
    private String province;

    @NotBlank(message = "시/도는 필수 입력 값 입니다.")
    private String city;

    private String locX;

    private String locY;

    private String img;

}
