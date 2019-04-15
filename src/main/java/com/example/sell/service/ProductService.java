package com.example.sell.service;

import com.example.sell.dataobject.ProductInfo;
import com.example.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 */
public interface ProductService {


    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // TODO: 2019/4/3 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // TODO: 2019/4/3 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
