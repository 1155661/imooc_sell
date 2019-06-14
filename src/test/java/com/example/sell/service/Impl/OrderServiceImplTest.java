package com.example.sell.service.Impl;

import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 请输入描述
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 19:30
 * * +----------------------------------------------------------------------
 * * | 代码创建: 莫祖能 <1468033693@qq.com>
 * * +----------------------------------------------------------------------
 * * | 版本信息: V1.0.0
 * * +----------------------------------------------------------------------
 * * | 代码修改:（修改人 - 修改时间）
 * * +----------------------------------------------------------------------
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();

        //  买家信息
        orderDTO.setBuyerName("莫");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("1234567899999");
        orderDTO.setBuyerOpenid("110112");

        //  购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("557");
        orderDetail.setProductQuantity(1);

        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void findish() {
    }

    @Test
    public void paid() {
    }
}