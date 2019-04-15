package com.example.sell.service.Impl;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.enums.ProductEnums;
import com.example.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");

        Assert.assertEquals("123456",productInfo.getProductId());

    }

    @Test
    public void findUpAll() {

        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());

    }

    @Test
    public void findAll() {

        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());

        Assert.assertNotEquals(0,productInfoPage.getTotalElements());

    }

    @Test
    public void save() {

        ProductInfo productinfo = new ProductInfo();

        productinfo.setProductId("123457");
        productinfo.setProductName("米饭");
        productinfo.setProductPrice(new BigDecimal(8));
        productinfo.setProductStock(100);
        productinfo.setProductDescription("泰国米饭");
        productinfo.setProductIcon("http://xxxx.jpg");
        productinfo.setProductStatus(ProductEnums.DOWN.getCode());
        productinfo.setCategoryType(2);

        ProductInfo productInfo = productService.save(productinfo);
        Assert.assertNotNull(productInfo);

    }
}