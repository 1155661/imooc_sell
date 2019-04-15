package com.example.sell.dao;

import com.example.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productinfo = new ProductInfo();

        productinfo.setProductId("123456");
        productinfo.setProductName("螺蛳粉");
        productinfo.setProductPrice(new BigDecimal(8));
        productinfo.setProductStock(100);
        productinfo.setProductDescription("dddddddddd");
        productinfo.setProductIcon("http://xxxx.jpg");
        productinfo.setProductStatus(0);
        productinfo.setCategoryType(2);

        ProductInfo info = repository.save(productinfo);
        Assert.assertNotNull(info);
    }


    @Test
    public void findByProductStatus() throws Exception{

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }

}