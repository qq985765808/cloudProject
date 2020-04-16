package com.wupeng.cloud.provider.payment8001.vo;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 菜单外表，不需要创建数据库表
 * @author Administrator
 * @date 2020-04-16
 */
//@Embeddable
public class MenuKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String href;

    public MenuKey(){
        super();
    }

    public MenuKey(Long id, String title, String href) {
        this.id = id;
        this.title = title;
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "MenuKey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
