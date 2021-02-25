package imooc.sell.repository;

import imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
@Test
public void  svae(){
    OrderDetail orderDetail=new OrderDetail();
    orderDetail.setDetailId("2");
    orderDetail.setOrderId("1");
    orderDetail.setProductId("123456");
    orderDetail.setProductName("皮蛋粥");
    orderDetail.setProductPrice(new BigDecimal(1.5));
    orderDetail.setProductQuantity(1);
    orderDetail.setProductIcon("xxx.jpg");
    OrderDetail result=repository.save(orderDetail);
    Assert.assertNotNull(result);
}
    @Test
   public void findByOrderId()  throws Exception {

    String orderid="1";
        List<OrderDetail> orderDetailList=repository.findByOrderId(orderid);
        Assert.assertNotEquals(0,orderDetailList.size());

    }
}