package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.entitry.User;
import cn.net.nikai.cloud.user.service.UserService;
import com.jiatui.spi.ServiceResponse;
import com.jiatui.spi.enums.ResponseErrorCodeEnum;
import com.jiatui.spi.util.JsonFactory;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务发布器
 *
 * @author nikai
 * @version 1.0.0
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all-users/query")
    @ResponseBody
    public ServiceResponse<List<User>> queryUsers() {
        try {
            List<User> users = userService.queryAll();
            return new ServiceResponse<List<User>>(users);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     query one user
     * </pre>
     * @param id userId
     * @return user
     */
    @GetMapping("/user/query")
    @ResponseBody
    public ServiceResponse<User> queryUserById(@RequestParam Long id) {
        log.info("input params: id={}",id);
        try {
            User user= userService.queryOne(id);
            return new ServiceResponse<User>(user);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(),e);
            return new ServiceResponse<User>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }


    /**
     * <pre>
     *     save user
     * </pre>
     *
     * @param user user
     * @return response
     */
    @PostMapping(value = "/user/add")
    @ResponseBody
    public ServiceResponse<String> saveUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.addOne(user);
            return new ServiceResponse<>("success");
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     update user
     * </pre>
     * @param user user
     * @return result
     */
    @PostMapping("/user/update")
    @ResponseBody
    public ServiceResponse updateUser(@RequestBody User user)
    {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.update(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    @PostMapping("/user/delete")
    @ResponseBody
    public ServiceResponse delUser(@RequestBody User user)
    {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.delete(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }
}
