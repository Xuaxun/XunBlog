package com.xun.dao;

import com.xun.entity.Article;
import com.xun.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {

    //获取前十篇文章
    List<Article> getFirst10Article();

    //通过id获取文章
    Article getArticleById(Long id);

    //通过文章类名
    List<Article> getArticlesByCategoryId(Long CategoryId);

    //获取全部文章
    List<Article> getArticles();

    //写文章
    void writeBlog(Article article);

    //通过类别名获取类别编号
    Long getCategoryIdByName(String name);

    //通过id删除文章
    void delArticleById(Long id);

    //修改文章
    void updateArticleById(Article article);

    //获取类别
    Category getCategoryById(Long id);



}
