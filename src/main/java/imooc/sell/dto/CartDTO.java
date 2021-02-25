package imooc.sell.dto;

import lombok.Data;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 15:43
 */
@Data
public class CartDTO
{
    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
