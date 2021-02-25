package imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class LoggerTest {
  // private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void Test1(){
        String name="imooc";
        String password="123456";
        log.info("name:{},password:{}",name,password);
        log.error("error.....33");
    }
}
