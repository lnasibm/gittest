package imooc.sell.repository;

import imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
      ProductCategory productCategory= repository.findById(1).get();
      System.out.println(productCategory.toString());
    }
    @Test
    public  void SaveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    public  void UpdateTest(){
        ProductCategory productCategory= repository.findById(2).get();
        productCategory.setCategoryType(50);
        repository.save(productCategory);
    }
    @Test
    @Transactional
    public  void InsertTest(){
        ProductCategory productCategory= new ProductCategory("小朋友最爱",111);
      ProductCategory Result=  repository.save(productCategory);
        Assert.assertNotNull(Result);
    }

    @Test
    public  void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(2,3,4);
      List<ProductCategory> Result=  repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,Result.size());
        System.out.println(Result.size());
    }


















}