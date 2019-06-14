package com.example.sell.dao;

import com.example.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * * +----------------------------------------------------------------------
 * * | 广西西途比网络科技有限公司 www.c2b666.com
 * * +----------------------------------------------------------------------
 * * | 功能描述: 请输入描述
 * * +----------------------------------------------------------------------
 * * | 时　　间: 2019/5/4 18:53
 * * +----------------------------------------------------------------------
 * * | 代码创建: 莫祖能 <1468033693@qq.com>
 * * +----------------------------------------------------------------------
 * * | 版本信息: V1.0.0
 * * +----------------------------------------------------------------------
 * * | 代码修改:（修改人 - 修改时间）
 * * +----------------------------------------------------------------------
 **/
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
