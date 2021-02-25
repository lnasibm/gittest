package imooc.sell.service;

import imooc.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
   ProductCategory findOne(Integer CategoryId);
   List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
