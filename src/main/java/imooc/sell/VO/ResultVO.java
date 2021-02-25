package imooc.sell.VO;

import lombok.Data;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/23 10:05
 */
@Data
public class ResultVO<T> {
    private  Integer code;
    private String msg;
    private T data;
}
