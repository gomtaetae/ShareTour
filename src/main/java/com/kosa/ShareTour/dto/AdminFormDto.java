package com.kosa.ShareTour.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

@Data
public class AdminFormDto{

    @NotBlank(message = "이름은 필수 입력 값입니다")
    private String name;


    @NotBlank(message = "비밀번호는 필수 입력 값입니다")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력 해야 합니다")
    private String password;



}
