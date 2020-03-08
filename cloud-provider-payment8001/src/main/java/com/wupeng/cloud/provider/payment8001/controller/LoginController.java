package com.wupeng.cloud.provider.payment8001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "index")
public class LoginController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("key","ll");
        return "index";
    }

}
