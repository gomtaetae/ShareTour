package com.kosa.ShareTour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PackageController {


    @GetMapping(value = "/auction")
    public String auctionPage(Model model){
        return "packages/auction";
    }

    @GetMapping(value = "/con_pro")
    public String conproductPage(Model model){
        return "packages/con_product_page";
    }

    @GetMapping(value = "/package")
    public String packagePage(Model model){
        return "packages/package_tour";
    }


}
