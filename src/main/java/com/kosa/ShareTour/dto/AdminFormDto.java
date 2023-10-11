package com.kosa.ShareTour.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminFormDto {

    private Integer id;

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;

    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력 해야 합니다")
    private String password;

}
