package com.wupeng.cloud.provider.payment8001.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 自定义异常控制器
 * @author Administrator
 * @date 2020-04-14
 */
@Controller
public class CustomErrorController implements ErrorController, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(CustomErrorController.class);
    /**
     *
     * @author Administrator
     * @date 2020-04-14
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/error")
    public String  handlerError(HttpServletRequest request, Model model){
        //获取状态码statusCode:400 404 500...
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        switch (statusCode){
            case 400:
                model.addAttribute("msg","您好:你的请求信息不合法,谢谢！");
                return "/error/400";
            case 401:
                model.addAttribute("msg","您好:你的身份没有经过服务器认证,请先认证谢谢！");
                return "/error/401";
            case 404:
                model.addAttribute("msg","您好:你请求的页面不存在,谢谢！");
                return "/error/404";
            case 405:
                model.addAttribute("msg","您好:你请求的方法被禁止,请换一种请求方式谢谢！");
                return "/error/403";
            default:
                model.addAttribute("msg","您好:服务器异常,请稍微等待一下谢谢！");
                return "/error/500";
        }

    }

    /**
     * 
     * @author Administrator
     * @date 2020-04-14 
     * @return
     */
    @Override
    public String getErrorPath() {
        return "error";
    }
}
