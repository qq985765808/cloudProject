package com.wupeng.cloud.mongodb.server8668.repository;

import com.wupeng.cloud.mongodb.server8668.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 文章Repository接口
 * @author Administrator
 * @date 2020-04-11
 */
public interface ActicleRepository extends MongoRepository<Article,String> {

    void deleteArticleById(String id);
}
