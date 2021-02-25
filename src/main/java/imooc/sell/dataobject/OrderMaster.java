package imooc.sell.dataobject;

import imooc.sell.enums.OrderStatusEnum;
import imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 9:13
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal OrderAmount;
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    private Integer PayStatus= PayStatusEnum.WAIT.getCode();
    private Date createTime;
    private Date updateTime;
//    @Transient
//    private List<OrderDetail> orderDetailList;
}

