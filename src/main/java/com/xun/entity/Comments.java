package com.xun.entity;

import lombok.Data;

/**
 * 评论实体类
 */
@Data
public class Comments {
    private long id;
    private long articleId;
    private String commIp;
    private String comment;
}
