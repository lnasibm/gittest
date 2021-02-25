package imooc.sell.service;

import imooc.sell.dataobject.ProductInfo;
import imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);
    /* 查询所有在架商品列表*/
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void  increaseStock(List<CartDTO> cartDTOSList);
    //减库存
    void  decreaseStock(List<CartDTO> cartDTOSList);
}
