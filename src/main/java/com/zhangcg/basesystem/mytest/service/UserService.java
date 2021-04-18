package com.zhangcg.basesystem.mytest.service;

import com.zhangcg.basesystem.mytest.dao.UserMapper;
import com.zhangcg.basesystem.mytest.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangcg
 * @ClassName UserService
 * @description
 * @date 2021/2/19 上午10:16
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) throws Exception{
        try {
            userMapper.insertSelective(user);
            int i = 1 / 0;
            return user;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
