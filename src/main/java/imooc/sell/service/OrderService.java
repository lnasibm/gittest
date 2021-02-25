package imooc.sell.service;

import imooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 13:34
 */

public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);
    //查询订单
    OrderDTO findOne(String orderId);
    //创建订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    //完成订单
    OrderDTO cancel(OrderDTO orderDTO);
    //取消订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderDTO paid(OrderDTO orderDTO);





}
