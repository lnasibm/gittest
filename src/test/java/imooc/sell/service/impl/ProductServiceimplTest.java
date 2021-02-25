package imooc.sell.service.impl;

import imooc.sell.dataobject.ProductInfo;
import imooc.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceimplTest {
    @Autowired
    private  ProductServiceimpl productService;
    @Test
    void findOne() throws Exception {
        ProductInfo productInfo=productService.findOne("123456");
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    void findUpAll() throws Exception {
        List<ProductInfo> productInfoList=productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
   public void findAll()  throws Exception{

        PageRequest request= PageRequest.of(0,2);
        Page<ProductInfo>  productInfoPage=productService.findAll((request));
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
//        System.out.println(productInfoPage.getTotalElements());
    }
    @Test
   public void save() throws Exception{
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}