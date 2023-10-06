package com.kosa.ShareTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    @GetMapping("/main")
    public String page() {
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/auction")
    public String mainAuction() {
        return "auction";
    }
    @GetMapping("/auctionplus")
    public String infoAuction() {
        return "auctionplus";
    }
    @GetMapping("/con_product_page")
    public String con_product() {
        return "con_product_page";
    }
    @GetMapping("/package_tour")
    public String tour() {
        return "package_tour";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }


}
