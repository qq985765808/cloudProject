package com.wupeng.cloud.provider.payment8001.service;

import com.wupeng.cloud.provider.payment8001.mongoDBEntity.SysMenu;

import java.util.List;

/**
 * 系统的基础菜单数据服务接口
 * @author Administrator
 * @date 2020-04-16
 */
public interface SysMenuService {

    /**
     * 获取全部的基础菜单数据
     * @author Administrator
     * @date 2020-04-16
     * @return
     */
    List<SysMenu> getAll();

    /**
     * 保存基础菜单数据
     * @author Administrator
     * @date 2020-04-16
     * @param sysMenu
     * @return
     */
    void saveSysMenu(SysMenu sysMenu);
}
