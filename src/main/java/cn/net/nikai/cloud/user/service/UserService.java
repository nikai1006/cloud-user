package cn.net.nikai.cloud.user.service;

import cn.net.nikai.cloud.user.entitry.User;
import java.util.List;

/**
 * service
 *
 * @author nikai
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {

    /**
     * @return
     */
    List<User> queryAll();

    /**
     * @param id
     * @return
     */
    User queryOne(long id);

    /**
     * @param user
     * @return
     */
    void addOne(User user);

    /**
     * @param user
     */
    void update(User user);

    /**
     * @param user
     */
    void delete(User user);
}