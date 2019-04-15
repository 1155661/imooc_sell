package com.example.sell.dao;

import com.example.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 商品
 *
 *
 * */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /** 查询已上架的商品 */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
