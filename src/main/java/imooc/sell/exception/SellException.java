package imooc.sell.exception;

import imooc.sell.enums.ResultEnum;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 13:48
 */
public class SellException extends  RuntimeException {
    private  Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
