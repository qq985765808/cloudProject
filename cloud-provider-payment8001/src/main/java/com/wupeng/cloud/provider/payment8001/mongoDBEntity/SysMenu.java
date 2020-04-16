package com.wupeng.cloud.provider.payment8001.mongoDBEntity;

import com.wupeng.cloud.provider.payment8001.vo.MenuKey;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统的基础菜单数据
 * @author Administrator
 * @date 2020-04-16
 */
@Document(collection = "SYS_MENUS")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field("sysMenu_id")
    private Long pid;
    @Field("icon")
    private String icon;
    @Field("target")
    private String target;
    @Field("sort")
    private Integer sort;
    @Field("status")
    private Boolean status;
    @Field("remark")
    private String remark;
    @Field("create_at")
    private Date create_at;
    @Field("update_at")
    private Date update_at;
    @Field("delete_at")
    private Date delete_at;
    @Field(value = "menuKeys")
    private List<MenuKey> menuKeys;

    public List<MenuKey> getMenuKeys() {
        return menuKeys;
    }

    public void setMenuKeys(List<MenuKey> menuKeys) {
        this.menuKeys = menuKeys;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = new Date();
    }

    public Date getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(Date delete_at) {
        this.delete_at = delete_at;
    }


}
