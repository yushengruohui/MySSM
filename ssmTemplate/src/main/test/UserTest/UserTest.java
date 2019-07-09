package UserTest;

import com.yusheng.pojo.User;
import com.yusheng.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UserTest {
    // 调用日志
    private static final Logger LOGGER = Logger.getLogger(UserTest.class);

    //@Resource 和 @Autowired 差不多
    @Autowired
    private UserService userService;

    @Test
    public void dome1(){
        User user = userService.getUserByName("jone");
        System.out.println(user);
        //或者日志输出
        //LOGGER.error(user);
    }

    @PostConstruct
    public void PostConstructDome2() {
        System.out.println("======在方法执行之前2======");
    }

}
