package org.sang.entity;

import lombok.Data;

/**
 * 文章实体类
 */
@Data
public class Article {
    private long id;
    private String title;
    private String content;
    private String date;
    private String summary;
    private String category;
    private long categoryId;

}
