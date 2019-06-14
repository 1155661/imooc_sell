package com.example.sell.service.Impl;

import com.example.sell.dao.OrderDetailDao;
import com.example.sell.dao.OrderMasterDao;
import com.example.sell.dataobject.OrderDetail;
import com.example.sell.dataobject.OrderMaster;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;
import com.example.sell.dto.OrderDTO;
import com.example.sell.enums.OrderStatusEnums;
import com.example.sell.enums.PayStatusEnum;
import com.example.sell.enums.ResultEnum;
import com.example.sell.service.OrderService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 请输入描述
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 19:05
 * * +----------------------------------------------------------------------
 * * | 代码创建: 莫祖能 <1468033693@qq.com>
 * * +----------------------------------------------------------------------
 * * | 版本信息: V1.0.0
 * * +----------------------------------------------------------------------
 * * | 代码修改:（修改人 - 修改时间）
 * * +----------------------------------------------------------------------
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderMasterDao orderMastesDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //  订单主表id
        String openid = KeyUtil.genUniqueKey();

        //  订单主表商品总额
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){

            //  根据订单详情获得对应的商品
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SecurityException(ResultEnum.PRODUCT_NOT_EXIST.getMessage());
            }

            //  计算总额
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //  订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(openid);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailDao.save(orderDetail);
        }

        //  订单主表入库
        OrderMaster orderMastes = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMastes);
        orderMastes.setOrderId(openid);
        orderMastes.setOrderAmount(orderAmount);
        orderMastes.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMastes.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMastesDao.save(orderMastes);

        //  扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String openid) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String openid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
