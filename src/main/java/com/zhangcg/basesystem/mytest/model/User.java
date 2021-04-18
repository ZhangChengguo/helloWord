package com.zhangcg.basesystem.mytest.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;

    private String name;

    private Integer age;

    private String gender;

    private static final long serialVersionUID = 1L;
}