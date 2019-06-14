package com.example.sell.dataobject;

import com.example.sell.enums.OrderStatusEnums;
import com.example.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 订单主表
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 18:37
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
@DynamicUpdate
public class OrderMaster {

    //  订单id
    @Id
    private String orderId;

    //  买家姓名
    private String buyerName;

    //  买家电话
    private String buyerPhone;

    //  买家地址
    private String buyerAddress;

    //  买家微信id
    private String buyerOpenid;

    //  订单总金额
    private BigDecimal orderAmount;

    //  订单状态    默认0 新下单
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();

    //  支付状态    默认0 未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //  创建时间
    private Date createTime;

    //  更新时间
    private Date updateTime;


}
