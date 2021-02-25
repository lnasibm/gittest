package imooc.sell.service.impl;

import com.sun.istack.NotNull;
import imooc.sell.dataobject.OrderDetail;
import imooc.sell.dataobject.OrderMaster;
import imooc.sell.dataobject.ProductInfo;
import imooc.sell.dto.CartDTO;
import imooc.sell.dto.OrderDTO;
import imooc.sell.enums.OrderStatusEnum;
import imooc.sell.enums.PayStatusEnum;
import imooc.sell.enums.ResultEnum;
import imooc.sell.exception.SellException;
import imooc.sell.repository.OrderDetailRepository;
import imooc.sell.repository.OrderMasterRepository;
import imooc.sell.repository.ProductInfoRepository;
import imooc.sell.service.OrderService;
import imooc.sell.service.ProductService;
import imooc.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 13:40
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniquKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList = new ArrayList<>();
        //1. 查询商品（数量, 价格）
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            String aa=orderDetail.getProductId();
            ProductInfo productInfo=productService.findOne(aa);
//            ProductInfo productInfo =  productService.findOne(aa);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//                throw new ResponseBankException();
            }
            //2. 计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniquKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }
        //3. 写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);

        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        //4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
//        //发送websocket消息
//        webSocket.sendMessage(orderDTO.getOrderId());
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
