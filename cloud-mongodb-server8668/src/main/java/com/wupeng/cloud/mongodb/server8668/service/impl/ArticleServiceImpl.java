package com.wupeng.cloud.mongodb.server8668.service.impl;

import com.wupeng.cloud.mongodb.server8668.entity.Article;
import com.wupeng.cloud.mongodb.server8668.repository.ActicleRepository;
import com.wupeng.cloud.mongodb.server8668.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章类的服务接口实现类
 * @author Administrator
 * @date 2020-04-11
 */
@Service
public class ArticleServiceImpl implements ArticleService,Serializable {

    private static final long serialVersionUID = 1L;
    public static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ActicleRepository acticleRepository;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     * */
    @Override
    public List<Article> findPaeg(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return acticleRepository.findAll(pageable).stream().collect(Collectors.toList());
    }

    @Override
    public void saveArtcleInfo(Article article) {
        acticleRepository.save(article);
    }

    @Override
    public void saveArtcleList(List<Article> list) {
        acticleRepository.insert(list);
    }

    @Override
    public void deleteArticleById(String id) {
        acticleRepository.deleteById(id);
    }


}
