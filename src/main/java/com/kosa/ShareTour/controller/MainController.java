package com.kosa.ShareTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String page() {
        return "main";
    }

    @GetMapping("/auction")
    public String pass() { return "auction";}
}