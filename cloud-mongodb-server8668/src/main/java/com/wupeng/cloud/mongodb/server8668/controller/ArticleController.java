package com.wupeng.cloud.mongodb.server8668.controller;

import com.wupeng.cloud.mongodb.server8668.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2020-04-11
 */
@RestController
@RequestMapping(value = "article")
public class ArticleController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 分页查询
     * */
    @RequestMapping(value = "/findAll")
    public Object findAll(
            @RequestParam(value = "pageNum",required = false)Integer pageNum,
            @RequestParam(value = "pageSize",required = false)Integer pageSize
    ){
        if(pageNum!=null && pageNum>0 && pageSize!=null && pageSize >0 ){
            return articleService.findPaeg(pageNum,pageSize);
        }
        return articleService.findPaeg(1,10);
    }

}
