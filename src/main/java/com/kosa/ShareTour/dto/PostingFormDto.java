package com.kosa.ShareTour.dto;

import com.kosa.ShareTour.entity.Member;
import com.kosa.ShareTour.entity.Posting;
import lombok.Data;
import org.modelmapper.ModelMapper;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class PostingFormDto {

    @NotBlank(message = "제목을 적어주세요")
    private String title;

    @NotBlank(message = "내용을 적어주세요")
    private String content;

    private Member member;

}
