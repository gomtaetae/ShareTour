package com.kosa.ShareTour.controller;

import com.kosa.ShareTour.dto.AccommodationFormDto;
import com.kosa.ShareTour.entity.Accommodation;
import com.kosa.ShareTour.service.AccommodationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccommodationController {

    @GetMapping(value = "/admin/accommo/add")
    public String accommoForm(Model model) {
        model.addAttribute("accommoFormDto", new AccommodationFormDto());
        return "packages/package_tour";
    }

}
