package com.wupeng.cloud.provider.payment8001.repository;

import com.wupeng.cloud.provider.payment8001.mongoDBEntity.SysMenu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 系统的基础菜单数据Mongodb接口
 * @author Administrator
 * @date 2020-04-16
 */

public interface SysMenuRepository extends MongoRepository<SysMenu,Long>,Serializable {


}
