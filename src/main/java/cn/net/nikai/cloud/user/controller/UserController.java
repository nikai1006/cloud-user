package cn.net.nikai.cloud.user.controller;

import cn.net.nikai.cloud.user.dto.User;
import cn.net.nikai.cloud.user.service.UserService;
import com.jiatui.spi.ServiceResponse;
import com.jiatui.spi.enums.ResponseErrorCodeEnum;
import com.jiatui.spi.util.JsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 服务发布器
 *
 * @author nikai
 * @version 1.0.0
 */
@RestController("/ai")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * <pre>
     *     查询所有的用户信息
     * <pre>
     * @service 所有用户信息查询
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @serviceType QUERY
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常; 41003:参数失败;2:操作繁忙;42020:无效的用户备注;
     * @author 尼凯:keni@aijiatui.com
     * @return 用户信息列表
     */
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
     *     根据用户id查询用户信息
     * <pre>
     * @service 根据用户id查询用户信息
     * @scene 新增用户;前端;商城业务
     * @param id 用户id
     * @domain BASE
     * @serviceType QUERY
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;42021:无效的id;
     * @author 尼凯:keni@aijiatui.com
     */
    @GetMapping("/user/query")
    @ResponseBody
    public ServiceResponse<User> queryUserById(@RequestParam Long id) {
        log.info("input params: id={}", id);
        try {
            User user = userService.queryOne(id);
            return new ServiceResponse<User>(user);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<User>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     根据用户id和用户名查询用户信息
     * <pre>
     * @service 根据用户id和用户名查询用户信息
     * @param userId 用户id
     * @param userName 用户姓名
     * @scene 新增用户;前端;商城业务
     * @domain BASE
     * @serviceType QUERY
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;42021:无效的id;
     * @author 尼凯:keni@aijiatui.com
     * @return 单个用户信息
     */
    @GetMapping("/user/find")
    @ResponseBody
    public ServiceResponse<User> findUser(Long userId, String userName) {
        log.info("input params: id={},name={}", userId, userName);
        try {
            User user = userService.queryOne(userId);
            return new ServiceResponse<User>(user);
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<User>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }


    /**
     * <pre>
     *     新增一个用户
     * <pre>
     * @service 新增用户
     * @scene 前端;商城业务
     * @domain BASE
     * @serviceType COMMAND
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     * @author nikai
     * @return 消息体
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
     *     修改用户信息
     * <pre>
     * @service 修改用户信息
     * @scene 前端;商城业务
     * @param user 用户信息
     * @domain BASE
     * @serviceType COMMAND
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     * @author 尼凯:keni@aijiatui.com
     */
    @PostMapping("/user/update")
    @ResponseBody
    public ServiceResponse updateUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.update(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * <pre>
     *     删除用户
     * <pre>
     * @service 删除用户
     * @scene 前端;商城业务
     * @param user 用户基本信息
     * @domain BASE
     * @serviceType COMMAND
     * @version 1.0.0
     * @returnCode 0:成功;1:系统异常;41003:参数失败;2:操作繁忙;
     * @author keni@aijiatui.com
     */
    @PostMapping("/user/delete")
    @ResponseBody
    public ServiceResponse delUser(@RequestBody User user) {
        try {
            log.info("input params:{}", JsonFactory.getDateFormatGsonInstance().toJson(user));
            userService.delete(user);
            return new ServiceResponse();
        } catch (Exception e) {
            log.error(ResponseErrorCodeEnum.SYSTEM_ERR.getMessage(), e);
            return new ServiceResponse<>(ResponseErrorCodeEnum.SYSTEM_ERR);
        }
    }

    /**
     * 泛型入参测试接口
     *
     * @service 泛型入参测试接口
     * @param users 用户列表
     * @domain BASE
     * @serviceType COMMAND
     * @returnCode 0:成功
     * @status DEPRECATED
     * @author keni@aijiatui.com
     * @author 尼凯
     */
    @GetMapping("/api/test")
    public User testUser(List<User> users) {

        return null;
    }

    /**
     * 空返回泛型入参测试接口
     *
     * @service 空返回泛型入参测试接口
     * @domain BASE
     * @serviceType COMMAND
     * @returnCode 0:成功
     * @status DEPRECATED
     * @author keni@aijiatui.com
     * @author 尼凯:keni@aijiatui.com
     */
    @GetMapping("/api/test2")
    public void testVoidAPI(Map<String,User> userMap){

    }
}
