package imooc.sell.service.impl;

import imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceimplTest {
@Autowired
private CategoryServiceimpl categoryService;
    @Test
    void findOne() throws  Exception     {
        ProductCategory productCategory=categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    void findAll() throws  Exception {
        List<ProductCategory> list=categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    void findByCategoryTypeIn() throws  Exception {
        List<ProductCategory> list=categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    void save() throws  Exception {
        ProductCategory productCategory = new ProductCategory("我的专享", 5);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}