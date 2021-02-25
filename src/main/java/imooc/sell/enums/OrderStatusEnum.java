package imooc.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum
{
    NEW(0,"新订间"),
    FINISHED(1,"订单完成"),
    CANCEL(2,"己取消"),;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
