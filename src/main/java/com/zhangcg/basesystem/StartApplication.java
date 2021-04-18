package com.zhangcg.basesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangcg
 * @ClassName StartApplication
 * @description
 * @date 2021/2/18 下午5:47
 */
@SpringBootApplication
@MapperScan("com.zhangcg.basesystem.*.dao")
@EnableTransactionManagement
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }
}
