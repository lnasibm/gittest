package imooc.sell.repository;

import imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    void saveTest() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    void findByProductStatus() {
        List<ProductInfo> productInfoList=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}