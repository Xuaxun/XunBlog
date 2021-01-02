package com.xun.dao;

import com.xun.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    public List<Article> getFirst10Article();
}
