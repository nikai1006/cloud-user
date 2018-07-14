package cn.net.nikai.cloud.user.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.net.nikai.cloud.user.entitry.User;
import cn.net.nikai.cloud.user.service.impl.UserServiceImpl;
import cn.net.nikai.cloud.user.util.LogUtil;

/**
 * {@link UserService}测试
 *
 * @author nikai
 * @version 1.0.0 2017/10/26 11:26
 * @see UserServiceImpl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);
    private LogUtil logUtil;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        logUtil = new LogUtil(LOGGER, UserServiceImpl.class);
    }

    /**
     * Test {@link UserServiceImpl#addOne(User)}
     *
     * @throws Exception
     * @see UserServiceImpl#addOne(User)
     */
    @Test
    public void addOne() throws Exception {
        logUtil.debug("addOne");
        User user = new User();
        user.setName("Jack");
        user.setAge(15);

        userService.addOne(user);
    }

    /**
     * 测试{@link UserServiceImpl#queryAll()}
     *
     * @throws Exception
     * @see UserServiceImpl#queryAll()
     */
    @Test
    public void queryAll() throws Exception {
        logUtil.debug("queryAll");
        List<User> users = userService.queryAll();
        for (User user : users) {
            LOGGER.debug(user.toString());
        }
    }

    /**
     * Test {@link UserServiceImpl#queryOne(long)}
     *
     * @throws Exception
     * @see UserServiceImpl#queryOne(long)
     */
    @Test
    public void queryOne() throws Exception {
        logUtil.debug("queryOne");
        User user = userService.queryOne(1000);
        LOGGER.debug(user.toString());
    }

    /**
     * Test {@link UserServiceImpl#update(User)}
     *
     * @throws Exception
     * @see UserServiceImpl#update(User)
     */
    @Test
    public void update() throws Exception {
        logUtil.debug("update");
        User user = new User();
        user.setName("Carl");
        user.setAge(50);
        user.setId(1000);
        userService.update(user);

    }

    /**
     * 测试{@link UserServiceImpl#delete(User)}
     *
     * @throws Exception
     * @see UserServiceImpl#delete(User)
     */
    @Test
    public void delete() throws Exception {
        logUtil.debug("delete");
        User user =new User();
        user.setId(1004);
        userService.delete(user);
    }

}