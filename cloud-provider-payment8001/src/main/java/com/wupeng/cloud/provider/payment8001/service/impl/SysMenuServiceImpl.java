package com.wupeng.cloud.provider.payment8001.service.impl;

import com.wupeng.cloud.provider.payment8001.mongoDBEntity.SysMenu;
import com.wupeng.cloud.provider.payment8001.repository.SysMenuRepository;
import com.wupeng.cloud.provider.payment8001.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统的基础菜单数据服务接口实现类
 * @author Administrator
 * @date 2020-04-16
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuRepository sysMenuRepository;


    @Override
    public List<SysMenu> getAll() {
        return sysMenuRepository.findAll();
    }

    @Override
    public void saveSysMenu(SysMenu sysMenu) {
        sysMenuRepository.save(sysMenu);
    }
}
