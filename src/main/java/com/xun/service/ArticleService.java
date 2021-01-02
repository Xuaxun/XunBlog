package com.xun.service;

import com.xun.dao.ArticleDao;
import com.xun.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    public List<Article> getFirst10Article() {
        return articleDao.getFirst10Article();
    }
}
