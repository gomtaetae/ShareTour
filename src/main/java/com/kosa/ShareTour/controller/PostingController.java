package com.kosa.ShareTour.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.kosa.ShareTour.dto.PostingFormDto;

import com.kosa.ShareTour.service.PostingService;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @GetMapping(value = "/user/posting/new")
    public String postingForm(Model model) {
        model.addAttribute("postingFormDto", new PostingFormDto());
        return "/posting/postingForm";
    }

    @PostMapping(value = "/user/posting/new")
    public String postingNew(@Valid PostingFormDto postingFormDto, BindingResult bindingResult,
                             Model model, @RequestParam("postimageFile") List<MultipartFile> postimageFileList,
                             Principal principal) {

        if(bindingResult.hasErrors()){
            return "posting/postingForm";
        }

//        if(postimageFileList.get(0).isEmpty() && postingFormDto.getId() == null){
//            model.addAttribute("errorMessage", "첫번째 이미지는 필수 입력 값 입니다.");
//            return "posting/postingForm";
//        }

        try {
            postingService.savePosting(postingFormDto, postimageFileList, principal.getName());
        } catch (Exception e){
            model.addAttribute("errorMessage", "게시글 등록 중 에러가 발생하였습니다.");
            return "posting/postingForm";
        }

        return "redirect:/";
    }

}
