package cn.net.nikai.cloud.user.dao;

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
import cn.net.nikai.cloud.user.util.LogUtil;

/**
 * {@link UserDao}测试
 *
 * @author nikai
 * @version 1.0.0 2017/10/26 10:12
 * @see UserDao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);
	private LogUtil logUtil;

	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		logUtil = new LogUtil(LOGGER, UserDao.class);
	}

	/**
	 * 测试{@link UserDao#addOne(User)}
	 *
	 * @throws Exception
	 * @see UserDao#addOne(User)
	 */
	@Test
	public void addOne() throws Exception {
		logUtil.debug("addOne");
		User user = new User();
		user.setName("Tom");
		user.setAge(20);
		int num = userDao.addOne(user);
		LOGGER.debug("新增[{}]条数据", num);

	}

	/**
	 * 测试{@link UserDao#queryAll()}
	 *
	 * @throws Exception
	 * @see UserDao#queryAll()
	 */
	@Test
	public void queryAll() throws Exception {
		logUtil.debug("queryAll");
		List<User> users = userDao.queryAll();
		for (User user : users) {
			LOGGER.debug(user.toString());
		}
	}

	/**
	 * 测试{@link UserDao#queryOne(long)}
	 *
	 * @throws Exception
	 * @see UserDao#queryOne(long)
	 */
	@Test
	public void queryOne() throws Exception {
		logUtil.debug("queryOne");
		User user = userDao.queryOne(1000);
		LOGGER.debug(user.toString());
	}


	/**
	 * 测试{@link UserDao#update(User)}
	 *
	 * @throws Exception
	 * @see UserDao#update(User)
	 */
	@Test
	public void update() throws Exception {
		logUtil.debug("update");
		User user = new User();
		user.setId(1001);
		user.setName("lucy");
		user.setAge(30);
		int num = userDao.update(user);
		LOGGER.debug("修改[{}]条数据", num);

	}

	/**
	 * 测试{@link UserDao#delete(long)}
	 *
	 * @throws Exception
	 * @see UserDao#delete(long)
	 */
	@Test
	public void delete() throws Exception {
		logUtil.debug("delete");
		int num = userDao.delete(1003);
		LOGGER.debug("删除[{}]条数据", num);

	}

}