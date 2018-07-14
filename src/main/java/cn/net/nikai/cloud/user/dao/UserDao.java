package cn.net.nikai.cloud.user.dao;


import java.util.List;
import cn.net.nikai.cloud.user.entitry.User;
/**
 *
* @author nikai
* @version V1.0.0
*
*/
public interface UserDao {
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
    int addOne(User user);

    /**
     * @param user
     */
    int update(User user);

    /**
     * @param id
     */
    int delete(long id);
}
