package com.xun.entity;

import lombok.Data;

/**
 * 文章种类实体
 */
@Data
public class Category {
    private long id;
    private String name;
    private String displayName;

}
