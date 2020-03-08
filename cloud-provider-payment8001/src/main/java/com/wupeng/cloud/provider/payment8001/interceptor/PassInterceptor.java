package com.wupeng.cloud.provider.payment8001.interceptor;

import com.wupeng.cloud.provider.payment8001.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * */
@Component
public  class PassInterceptor implements HandlerInterceptor{

    private static final Logger log = LoggerFactory.getLogger(PassInterceptor.class);

    @Autowired
    private RedisService redisService;

    public static  PassInterceptor passInterceptor;

    /**
     * 初始化redis 服务类
     * */
    @PostConstruct
    public  void init(){
        passInterceptor = this;
        passInterceptor.redisService =  this.redisService;
    }

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();
        //System.out.println(url);
        log.info("请求路径为："+url);
        //log.info("访问IP为："+ NetWorkUtil.getIpAddress(request));
        // url.indexOf("getIndex")==-1
        if(url!=null ){
            try{
                if( passInterceptor.redisService.get("userLogin")==null){
                    //response.sendRedirect("/project/index/getIndex"); //war包版本的路径
                    //response.getOutputStream().write("Ne rajtigita".getBytes());
                    response.sendRedirect("/index");
                    return false;
                }
                return   true;
            }catch (Exception e){
                e.printStackTrace();
                //response.sendRedirect("/project/index/getIndex");//war包版本的路径
                response.sendRedirect("/index");
                return  false;
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle...");
        log.info("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion...");
        log.info("afterCompletion...");
    }
}
