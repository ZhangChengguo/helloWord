package com.zhangcg.basesystem.mytest.annotation;

import java.lang.annotation.*;

/**
 * @author zhangcg
 * @ClassName ChecKNull
 * @description
 * @date 2021/4/2 下午2:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface CheckNull {
}
