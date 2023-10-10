package com.kosa.ShareTour.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 값입니다")
    @Email(message = "이메일 형식으로 입력 해야됩니다")
    private String email;

    @NotBlank(message = "닉네임은 필 수 입력 값입니다")
    private String nickname;

    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력 해야 합니다")
    private String password;

    private LocalDateTime createTime;

    private String imgUrl;

    @NotBlank(message = "성별은 필수 입력 ")
    private String gender;

    @NotBlank(message = "생년월일은 필수 입력값입니다")
    @Length(min = 8, max = 8, message = "생년월일은 8자로 입력 해야 됩니다")
    private LocalDate birthday;

    @NotBlank(message = "전화번호는 필수 입력값입니다")
    @Length(min = 8, max= 8, message = "전화번호는 '-'없이 11자 이하로 입력 해야 됩니다")
    private String phone;

    private String address;

    private String grade;

}
