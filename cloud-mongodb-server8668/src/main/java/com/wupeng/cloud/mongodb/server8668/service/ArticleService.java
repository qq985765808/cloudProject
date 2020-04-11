package com.wupeng.cloud.mongodb.server8668.service;

import com.wupeng.cloud.mongodb.server8668.entity.Article;

import java.util.List;

/**
 * 文章类的服务接口
 * @author Administrator
 * @date 2020-04-11
 */
public interface ArticleService  {

    /**
     * 文章信息分页
     * @param pageNum
     * @param pageSize
     * @return list
     * */
    public List<Article> findPaeg(int pageNum, int pageSize);

    /**
     *  新增文章
     * @param article
     * */
    public void saveArtcleInfo(Article article);

    /**
     *  批量新增文章
     * @param list
     * */
    void saveArtcleList(List<Article> list);

    void deleteArticleById(String id);
}
