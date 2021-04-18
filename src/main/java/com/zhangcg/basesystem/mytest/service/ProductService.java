package com.zhangcg.basesystem.mytest.service;

import com.zhangcg.basesystem.mytest.dao.ProductMapper;
import com.zhangcg.basesystem.mytest.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangcg
 * @ClassName ProductService
 * @description
 * @date 2021/2/22 上午9:00
 */
@Service
@Slf4j
public class ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private RedissonClient redissonClient;

    public boolean addOrder(int productId)throws Exception{
        String lockKey = "product_count_key_"+productId;
        RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock();
            Product product = productMapper.selectByPrimaryKey(productId);
            if (product == null) {
                log.info("产品代买错误！");
                return false;
            }

            int count = product.getProductCount();
            if (count == 0) {
                log.info("产品库存不足！");
                return false;
            }

            count--;
            product.setProductCount(count);
            productMapper.updateByPrimaryKey(product);
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            lock.unlock();
        }
        return true;
    }


    public String addProduct(Product product) throws Exception{
        int flag = productMapper.insertSelective(product);
        if (flag<=0){
            throw new Exception("产品添加失败");
        }
        return product.getProductName()+"添加成功！";
    }
}
