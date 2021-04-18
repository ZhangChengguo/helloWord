package com.zhangcg.basesystem.mytest.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Product implements Serializable {
    private Integer id;

    private String productName;

    private Integer productCount;

    private Long productPrice;

    private String productType;

    private static final long serialVersionUID = 1L;
}