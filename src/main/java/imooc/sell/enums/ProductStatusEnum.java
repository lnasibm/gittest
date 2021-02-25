package imooc.sell.enums;

import lombok.Getter;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架");
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.message=message;
        this.code = code;
    }
}
