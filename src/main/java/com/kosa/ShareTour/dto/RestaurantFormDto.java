package com.kosa.ShareTour.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RestaurantFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;

    private String address;

    private String phone;

    private String area;

    private String parking;

    private String locX;

    private String locY;

    @NotBlank(message = "가격은 필수 입력 입니다.")
    private String price;

}
