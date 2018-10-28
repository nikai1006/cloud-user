package cn.net.nikai.cloud.user.service.impl;

import cn.net.nikai.cloud.user.dao.UserDao;
import cn.net.nikai.cloud.user.dto.User;
import cn.net.nikai.cloud.user.exception.AppException;
import cn.net.nikai.cloud.user.service.UserService;
import com.jiatui.spi.util.JsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nikai
 * @version 1.0.0 2017/10/26 11:08
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAll() {
        LOGGER.info("queryAll");
        return userDao.queryAll();
    }

    @Override
    public User queryOne(long id) {
        LOGGER.info("queryOne [{}]", id);
        return userDao.queryOne(id);
    }

    @Override
    public void addOne(User user) {
        LOGGER.info("addOne [{}]", user.toString());
        try {
            userDao.addOne(user);
        } catch (Exception e) {
            throw new AppException(e);
        }
    }

    @Override
    public void update(User user) {
        LOGGER.info("update [{}]", user.toString());
        try {
            userDao.update(user);
        } catch (Exception e) {
            throw new AppException(e);
        }
    }

    @Override
    public void delete(User user) {
        LOGGER.info("delete [{}]", JsonFactory.getDateFormatGsonInstance().toJson(user));
        userDao.delete(user.getId());
    }
}
