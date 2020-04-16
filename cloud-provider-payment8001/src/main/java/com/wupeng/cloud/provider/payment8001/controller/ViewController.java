package com.wupeng.cloud.provider.payment8001.controller;

import com.wupeng.cloud.provider.payment8001.mongoDBEntity.SysMenu;
import com.wupeng.cloud.provider.payment8001.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端页面基础数据控制器
 * @author Administrator
 * @date 2020-04-16
 */
@RestController
@RequestMapping(value = "ViewInit")
public class ViewController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private SysMenuService sysMenuService;



    /**
     * 初始化页面菜单
     * @author Administrator
     * @date 2020-04-16
     * @return
     */
    @RequestMapping(value = "/initViewMenu")
    public Object initViewMenu(){
        return sysMenuService.getAll();
    }

    /**
     * 保存页面基础菜单数据
     * @author Administrator
     * @date 2020-04-16
     * @return
     */
    @RequestMapping(value = "/saveViewByMenuData")
    public Object saveViewByMenuData(){
        Map map = new HashMap();
        map.put("msg","ok");
        //sysMenuService.saveSysMenu(new SysMenu());
        return  map;
    }
}
