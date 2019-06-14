package com.example.sell.service;

import com.example.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 订单主表Service
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 18:58
 * * +----------------------------------------------------------------------
 * * | 代码创建: 莫祖能 <1468033693@qq.com>
 * * +----------------------------------------------------------------------
 * * | 版本信息: V1.0.0
 * * +----------------------------------------------------------------------
 * * | 代码修改:（修改人 - 修改时间）
 * * +----------------------------------------------------------------------
 **/
public interface OrderService {

    //  创建订单
    OrderDTO create(OrderDTO orderDTO);

    //  查询单个订单
    OrderDTO findOne(String openid);

    //  查询订单列表
    Page<OrderDTO> findList(String openid, Pageable pageable);

    //  取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //  完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //  支付订单
    OrderDTO paid(OrderDTO orderDTO);

}
