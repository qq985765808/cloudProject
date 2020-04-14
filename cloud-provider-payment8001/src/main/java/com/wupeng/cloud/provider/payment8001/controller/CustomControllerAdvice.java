package com.wupeng.cloud.provider.payment8001.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.Serializable;

/**
 * 自定义控制器异常切面
 * @author Administrator
 * @date 2020-04-14
 */
@ControllerAdvice
public class CustomControllerAdvice implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(CustomControllerAdvice.class);



}
