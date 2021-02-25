package imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 9:35
 */
@Entity
@Data
public class OrderDetail {
//    @Id
//    private String detailId;
//    private String orderId;
//    private String productId;
//    private String productName;
//    private BigDecimal productPrice;
//    private Integer productQuantity;
//    private String productIcon;
    @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;



}
