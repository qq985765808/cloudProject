package com.wupeng.cloud.provider.payment8001.controller;

import com.wupeng.cloud.provider.payment8001.utils.AesException;
import com.wupeng.cloud.provider.payment8001.utils.WXPublicUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/main")
    public String main(Model model){
        model.addAttribute("username","吴鹏");
        return "main";
    }

    @RequestMapping("/verify_wx_token")
    @ResponseBody
    public String verifyWXToken(HttpServletRequest request) throws AesException {
        String msgSignature = request.getParameter("signature");
        String msgTimestamp = request.getParameter("timestamp");
        String msgNonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (WXPublicUtils.verifyUrl(msgSignature, msgTimestamp, msgNonce)) {
            return echostr;
        }
        return null;
    }

}
