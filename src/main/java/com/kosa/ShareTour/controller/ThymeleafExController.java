package com.kosa.ShareTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
    @GetMapping(value = "/main")
    public String mainPage(Model model){
        return "thymeleaf/main";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model){
        return "thymeleaf/login";
    }

    @GetMapping(value = "/auction")
    public String auctionPage(Model model){
        return "thymeleaf/auction";
    }

    @GetMapping(value = "/con_pro")
    public String conproductPage(Model model){
        return "thymeleaf/con_pro";
    }

    @GetMapping(value = "/package")
    public String packagePage(Model model){
        return "thymeleaf/package_tour";
    }

    @GetMapping(value = "/post")
    public String postPage(Model model){
        return "thymeleaf/post";
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model){
        return "thymeleaf/register";
    }

    @GetMapping(value = "/view")
    public String viewPage(Model model){
        return "thymeleaf/veiw";
    }

    @GetMapping(value = "/write")
    public String writePage(Model model){
        return "thymeleaf/write";
    }
}
