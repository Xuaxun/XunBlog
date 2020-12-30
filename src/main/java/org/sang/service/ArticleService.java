package org.sang.service;

import org.sang.dao.ArticleDao;
import org.sang.entity.Article;
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
