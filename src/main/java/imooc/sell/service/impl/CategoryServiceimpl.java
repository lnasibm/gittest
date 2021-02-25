package imooc.sell.service.impl;

import imooc.sell.dataobject.ProductCategory;
import imooc.sell.repository.ProductCategoryRepository;
import imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceimpl implements CategoryService {
@Autowired
  private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer CategoryId) {
        return repository.findById(CategoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
