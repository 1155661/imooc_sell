package com.example.sell.controller;

import com.example.sell.VO.ProductInfoVO;
import com.example.sell.VO.ProductVO;
import com.example.sell.VO.ResultVO;
import com.example.sell.dataobject.ProductCategory;
import com.example.sell.dataobject.ProductInfo;
import com.example.sell.service.CategoryService;
import com.example.sell.service.ProductService;
import com.example.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Object list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList =  productService.findUpAll();

        //遍历商品的类目  product_info.category_type = product_category.category_type
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        //2.根据商品的类目查询类目表中的数据，即查询用到的类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼装
        //遍历类目
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){

            //拼接类目对象
            ProductVO productVO = new ProductVO();
            //类目的type
            productVO.setCategoryType(productCategory.getCategoryType());
            //类目的name
            productVO.setCategoryName(productCategory.getCategoryName());



            //遍历已上架的商品数据
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){

                //商品的type与类目的type是否相等
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    //spring自带的，可以把一个对象属性的值，拷贝到另一个对象里面去
                    BeanUtils.copyProperties(productInfo,productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }

            //跟类目相关的数据
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }


}
