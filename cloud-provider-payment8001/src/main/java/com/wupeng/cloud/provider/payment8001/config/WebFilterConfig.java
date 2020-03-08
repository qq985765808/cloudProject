package com.wupeng.cloud.provider.payment8001.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*")
@Order(value = 1)
@Configuration
public class WebFilterConfig implements Filter {

    private static final Logger log = LoggerFactory.getLogger(WebFilterConfig.class);
    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/login", "/index", "/register","/druid/weburi.html")));


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("init  filter");
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        if (allowedPath) {
            log.info("这里是不需要处理的url进入的方法");
            chain.doFilter(req, res);
        } else {
            log.debug("这里是需要处理的url进入的方法");
            chain.doFilter(req, res);
    }




    }

    @Override
    public void destroy() {
        log.info("destroy   filter");
    }


}
