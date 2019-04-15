package com.example.sell.dao;

import com.example.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    @Test
    @Transactional          //测试通过后不会向数据库写入数据
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",2);

        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);   //判断是否成功

    }

    @Test
    public void findByCategoryTypeIn(){

    }
}