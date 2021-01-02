package com.xun.service;

import com.xun.dao.ArticleDao;
import com.xun.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //获取前十篇文章
    public List<Article> getFirst10Article() {
        return articleDao.getFirst10Article();
    }

    public Article getArticleById(Long id){
        Article article = articleDao.getArticleById(id);
        article.setCategory(articleDao.getCategoryById(article.getCategoryId()).getDisplayName());
        return article;
    }

    public List<Article> getArticles(){
        return articleDao.getArticles();
    }

    public void writeBlog(Article article){
        Long categoryId = articleDao.getCategoryIdByName(article.getCategory());
        article.setCategoryId(categoryId);
        article.setDate(sdf.format(new Date()));
        if (article.getSummary() == null || "".equals(article.getSummary())){
            if (article.getContent().length()>20){
                article.setSummary(article.getContent().substring(0,20));
            }else{
                article.setSummary(article.getContent().substring(0, article.getContent().length()));
            }
        }
        articleDao.writeBlog(article);
    }

    public List<Article> getArticlesByCategoryName(String name) {
        Long categoryId = articleDao.getCategoryIdByName(name);
        List<Article> articles = articleDao.getArticlesByCategoryId(categoryId);
        return articles;
    }

    public void updateBlog(Article article){
        article.setDate(sdf.format(new Date()));
        if (article.getSummary() == null || "".equals(article.getSummary())) {
            if (article.getContent().length() > 20) {
                article.setSummary(article.getContent().substring(0, 20));
            } else {
                article.setSummary(article.getContent().substring(0, article.getContent().length()));
            }
        }
        articleDao.updateArticleById(article);
    }




}
