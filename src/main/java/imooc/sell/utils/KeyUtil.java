package imooc.sell.utils;

import java.util.Random;

/**
 * @Description
 * @Author XZG
 * @Date 2021/2/24 14:05
 */
public class KeyUtil {
    /*
    * 生成唯一主健
    * 格式：时间+随机数
    * */
    public static synchronized   String getUniquKey(){
        Random random=new Random();
//        生成6位随机数
        Integer number=random.nextInt(900000)+100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
