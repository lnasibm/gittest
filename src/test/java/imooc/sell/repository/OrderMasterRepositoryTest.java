package imooc.sell.repository;

import imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    private  final  String openid="110110";
    @Test
    public void  saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123");
        orderMaster.setBuyerName("大哥");
        orderMaster.setBuyerPhone("15804125566");
        orderMaster.setBuyerAddress("辽宁省鞍山市");
        orderMaster.setBuyerOpenid(openid);
        orderMaster.setOrderAmount(new BigDecimal(5.5));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);


    }

    @Test
    void findByBuyerOpenid() {
        PageRequest request=PageRequest.of(1,1);
        Page<OrderMaster> result= repository.findByBuyerOpenid(openid, request);
        System.out.println(result.getTotalElements());

    }
}