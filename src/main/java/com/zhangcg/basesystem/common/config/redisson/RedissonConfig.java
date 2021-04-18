package com.zhangcg.basesystem.common.config.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangcg
 * @ClassName RedissonConfig
 * @description
 * @date 2021/2/22 上午10:36
 */
@Configuration
public class RedissonConfig {
    @Value("${redisson.address}")
    private String addressUrl;
    @Value("${redisson.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(addressUrl)
                .setPassword(password)
                .setConnectTimeout(10000)
                .setRetryInterval(5000)
                .setTimeout(10000);
        return Redisson.create(config);
    }
}
