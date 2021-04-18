package com.zhangcg.basesystem.mytest.controller;

import com.zhangcg.basesystem.mytest.model.Product;
import com.zhangcg.basesystem.mytest.model.User;
import com.zhangcg.basesystem.mytest.service.ProductService;
import com.zhangcg.basesystem.mytest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangcg
 * @ClassName MyTestController
 * @description
 * @date 2021/2/19 上午8:58
 */
@RestController
@RequestMapping("/mytest")
@Api(value = "测试类控制器")
public class MyTestController {

    @Resource
    private ProductService productService;

    @GetMapping("/myTest")
    @ResponseBody
    @ApiOperation(value = "测试接口")
    public String myTest(){
        return "ok";
    }

    @PutMapping("/product")
    @ResponseBody
    @ApiOperation(value = "添加产品")
    public String addProduct(@RequestBody Product product) throws Exception{
        return productService.addProduct(product);
    }

    @GetMapping("/product")
    @ResponseBody
    @ApiOperation(value = "添加订单")
    public String updateProduct() throws Exception{
        if (!productService.addOrder(1)){
            return "订单创建失败！";
        }else{
            return "订单创建成功！";
        }
    }
}
