package com.example.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 订单详情
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 18:46
 * * +----------------------------------------------------------------------
 * * | 代码创建: 莫祖能 <1468033693@qq.com>
 * * +----------------------------------------------------------------------
 * * | 版本信息: V1.0.0
 * * +----------------------------------------------------------------------
 * * | 代码修改:（修改人 - 修改时间）
 * * +----------------------------------------------------------------------
 **/
@Entity
@Data
public class OrderDetail {

    //  详情id
    @Id
    private String detailId;

    //  订单主表id
    private String orderId;

    //  商品id
    private String productId;

    //  商品名称
    private String productName;

    //  商品单价
    private BigDecimal productPrice;

    //  商品数量
    private Integer productQuantity;

    //  商品小图
    private String productIcon;

}
