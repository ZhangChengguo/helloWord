package com.zhangcg.basesystem.mytest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author zhangcg
 * @ClassName CheckNullAop
 * @description
 * @date 2021/4/2 下午2:13
 */

@Aspect
@Component
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
public class CheckNullAop {

    @Pointcut(value = "execution(* com.zhangcg.basesystem.mytest..*.*(..)) && @annotation(CheckNull)")
    private void isAnnotation(){}

}
