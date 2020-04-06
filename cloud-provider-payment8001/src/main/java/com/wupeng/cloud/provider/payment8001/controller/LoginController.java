package com.wupeng.cloud.provider.payment8001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "index")
public class LoginController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("username","吴鹏");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("username","吴鹏");
        return "login";
    }

    @RequestMapping(value = "/registered")
    public String registered(Model model){
        model.addAttribute("username","吴鹏");
        return "registered";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(Model model){
        model.addAttribute("username","吴鹏");
        return "registered";
    }
}
