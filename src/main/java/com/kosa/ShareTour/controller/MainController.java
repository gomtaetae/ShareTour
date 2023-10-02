package com.kosa.ShareTour.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String page() {
        return "main";
    }

    @GetMapping("/auction")
    public String mainAuction() {
        return "auction";
    }

    @GetMapping("/auctionplus")
    public String infoAuction() {
        return "auctionplus";
    }
}